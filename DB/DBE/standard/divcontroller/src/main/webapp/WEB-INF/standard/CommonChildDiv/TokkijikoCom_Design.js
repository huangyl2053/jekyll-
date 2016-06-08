var DBE;
(function (DBE) {
    (function (TokkijikoCom) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TokkijikoCom.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TokkijikoCom";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.TokkijikoCom.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.TokkijikoCom.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TokkijikoCom = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlChosaItem = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChosaItem"));
            };

            Controls.prototype.txtTokkijikoContent = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoContent"));
            };

            Controls.prototype.lblSpace = function () {
                return new UZA.Label(this.convFiledName("lblSpace"));
            };
            return Controls;
        })();
        TokkijikoCom.Controls = Controls;
    })(DBE.TokkijikoCom || (DBE.TokkijikoCom = {}));
    var TokkijikoCom = DBE.TokkijikoCom;
})(DBE || (DBE = {}));
