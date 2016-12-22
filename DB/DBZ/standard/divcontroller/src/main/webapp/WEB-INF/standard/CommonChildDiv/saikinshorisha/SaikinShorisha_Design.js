var DBZ;
(function (DBZ) {
    (function (SaikinShorisha) {
        var Events = (function () {
            function Events() {
            }
            Events.onSaikishorishaClick = function () {
                return "onSaikishorishaClick";
            };
            return Events;
        })();
        SaikinShorisha.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SaikinShorisha";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SaikinShorisha.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SaikinShorisha.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SaikinShorisha = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlSaikinShorisha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSaikinShorisha"));
            };

            Controls.prototype.btnConfirm = function () {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            };
            return Controls;
        })();
        SaikinShorisha.Controls = Controls;
    })(DBZ.SaikinShorisha || (DBZ.SaikinShorisha = {}));
    var SaikinShorisha = DBZ.SaikinShorisha;
})(DBZ || (DBZ = {}));
