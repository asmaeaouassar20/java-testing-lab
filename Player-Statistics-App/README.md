# Java Unit Testing - JUnit & Mockito

## Création du projet Java

* Classes Java pour une application de statistiques de joueurs.

## JUnit

* Création de classes de test.
* `assertEquals`, `assertNotEquals`, `assertSame`.
* `assertTrue`, `assertFalse`.
* `assertNull`, `assertNotNull`.
* `assertArrayEquals`.

## Préparation des tests

**Exemple** : `@BeforeEach` pour exécuter du code avant chaque test.


## Tests paramétrés

* Tester une même méthode avec plusieurs données.

## Tests des exceptions

* `assertThrows` pour vérifier qu’une exception est bien levée.
* `assertEquals` pour vérifier le message de l’exception.

## Mockito

* Ajout de la dépendance Mockito.
* Simulation d’une connexion à la base de données.
* `mock()` → créer un objet simulé.
* `when()` → définir la méthode à simuler.
* `thenReturn()` → définir la valeur retournée par le mock.
