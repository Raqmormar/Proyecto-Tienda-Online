//cart.js
console.log("El archivo JavaScript está correctamente enlazado");

document.addEventListener('DOMContentLoaded', () => {
    let currentSlide = 0;

    function moveSlide(direction) {
        const slides = document.querySelectorAll('.carrusel-slide');
        const totalSlides = slides.length;

        currentSlide += direction;

        if (currentSlide >= totalSlides) {
            currentSlide = 0;
        } else if (currentSlide < 0) {
            currentSlide = totalSlides - 1;
        }

        const carruselContainer = document.querySelector('.carrusel-container');
        carruselContainer.style.transform = `translateX(-${currentSlide * 100}%)`;
    }

    // Auto move slides every 3 seconds
    setInterval(() => {
        moveSlide(1);
    }, 3000);
});