/**
 * Stomp client
 */
const rootContext = '/' + window.location.pathname.split('/')[1];
const socket = new SockJS(rootContext + '/market');
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
const bidSpanElement = document.getElementById('bid_span');

bidLinkElement.addEventListener('click', () => {
	console.log("Bid link clicked")
});

/**
 * Push the given content to server
 * @param content
 */
function push(content) {
	const payload = JSON.stringify(content);
	client.send('/app/place', {}, payload);
}

/**
 * Update ui
 * @param product
 */
function updateUI(product) {
	// TODO Find the element with product.id
	bidSpanElement.innerHTML = product.price;
}

/**
 * Response from serve
 * @param frame
 */
function update(frame) {
	console.log(frame);
}