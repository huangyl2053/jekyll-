var DBZ;
(function (DBZ) {
    (function (ChosaTokkiImageShokai) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        ChosaTokkiImageShokai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaTokkiImageShokai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ChosaTokkiImageShokai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChosaTokkiImageShokai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaTokkiImageShokai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        ChosaTokkiImageShokai.Controls = Controls;
    })(DBZ.ChosaTokkiImageShokai || (DBZ.ChosaTokkiImageShokai = {}));
    var ChosaTokkiImageShokai = DBZ.ChosaTokkiImageShokai;
})(DBZ || (DBZ = {}));
