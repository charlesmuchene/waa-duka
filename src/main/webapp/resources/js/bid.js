/**
 * Stomp client
 */
const rootContext = '/' + window.location.pathname.split('/')[1];
const socket = new SockJS(/*rootContext + */'/market'); // TODO Remove if not launching at root
const client = Stomp.over(socket);
const username = "guest";
const password = "guest";

/**
 * Called when client is connected to server
 * @returns {{unsubscribe: (function(): *), id: *}}
 */
const connectCallback = () => client.subscribe('/topic/place', update);

/**
 * Called when client cannot connect to server
 * @param error
 */
const errorCallback = (error) => console.log(error);

client.connect(username, password, connectCallback, errorCallback);

/**
 * Set up racing world!
 */
const bidLinkElement = document.getElementById('bid_link');
const priceSpanElement = document.getElementById('price_span');
const bidPriceElement = document.getElementById('bid_amount');

bidLinkElement.addEventListener('click', () => {
	const price = bidPriceElement.value;
	const payload = {
		productId: 1,
		price: price
	};
	push(payload);
	console.log('Pushed:', payload);
});

/**
 * Push the given content to server
 * @param content
 */
function push(content) {
	content = JSON.stringify(content);
	client.send('/app/place', {}, content);
}

/**
 * Update ui
 * @param product
 */
function updateUI(product) {
	// TODO Find the element with product.id
	priceSpanElement.innerHTML = 'Kes. ' + product.price;
}

/**
 * Response from serve
 * @param frame
 */
function update(frame) {
	console.log(frame);
	updateUI(JSON.parse(frame.body));
}