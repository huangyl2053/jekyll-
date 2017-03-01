var DBE;
(function (DBE) {
    (function (ChosaKekkaTokkiImages) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ChosaKekkaTokkiImages.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaKekkaTokkiImages";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ChosaKekkaTokkiImages.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ChosaKekkaTokkiImages.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaKekkaTokkiImages = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlTokkiJikoNos = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTokkiJikoNos"));
            };

            Controls.prototype.btnToDisplay = function () {
                return new UZA.Button(this.convFiledName("btnToDisplay"));
            };
            return Controls;
        })();
        ChosaKekkaTokkiImages.Controls = Controls;
    })(DBE.ChosaKekkaTokkiImages || (DBE.ChosaKekkaTokkiImages = {}));
    var ChosaKekkaTokkiImages = DBE.ChosaKekkaTokkiImages;
})(DBE || (DBE = {}));
