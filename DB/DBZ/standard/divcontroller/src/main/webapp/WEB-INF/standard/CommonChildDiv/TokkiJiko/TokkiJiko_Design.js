var DBZ;
(function (DBZ) {
    (function (TokkiJiko) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TokkiJiko.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TokkiJiko";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.TokkiJiko.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.TokkiJiko.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TokkiJiko = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblTokki = function () {
                return new UZA.Label(this.convFiledName("lblTokki"));
            };

            Controls.prototype.imgTokkiJiko = function () {
                return new UZA.StaticImage(this.convFiledName("imgTokkiJiko"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnKoshin = function () {
                return new UZA.Button(this.convFiledName("btnKoshin"));
            };

            Controls.prototype.btnMasking = function () {
                return new UZA.Button(this.convFiledName("btnMasking"));
            };
            return Controls;
        })();
        TokkiJiko.Controls = Controls;
    })(DBZ.TokkiJiko || (DBZ.TokkiJiko = {}));
    var TokkiJiko = DBZ.TokkiJiko;
})(DBZ || (DBZ = {}));
