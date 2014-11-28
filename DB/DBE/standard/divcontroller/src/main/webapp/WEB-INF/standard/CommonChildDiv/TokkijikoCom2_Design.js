var DBE;
(function (DBE) {
    (function (TokkijikoCom2) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TokkijikoCom2.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TokkijikoCom2";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.TokkijikoCom2.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.TokkijikoCom2.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TokkijikoCom2 = function () {
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
        TokkijikoCom2.Controls = Controls;
    })(DBE.TokkijikoCom2 || (DBE.TokkijikoCom2 = {}));
    var TokkijikoCom2 = DBE.TokkijikoCom2;
})(DBE || (DBE = {}));
