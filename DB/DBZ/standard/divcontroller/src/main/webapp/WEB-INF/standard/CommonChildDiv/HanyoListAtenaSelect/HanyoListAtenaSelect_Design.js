var DBZ;
(function (DBZ) {
    (function (HanyoListAtenaSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_SelectKijun = function () {
                return "onChange_SelectKijun";
            };

            Events.onChange_SelectChiku = function () {
                return "onChange_SelectChiku";
            };
            return Events;
        })();
        HanyoListAtenaSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HanyoListAtenaSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HanyoListAtenaSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HanyoListAtenaSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HanyoListAtenaSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.DvAtena = function () {
                return new UZA.Panel(this.convFiledName("DvAtena"));
            };

            Controls.prototype.DvJokenSelect = function () {
                return new UZA.Panel(this.convFiledName("DvJokenSelect"));
            };

            Controls.prototype.radSelectKijun = function () {
                return new UZA.RadioButton(this.convFiledName("radSelectKijun"));
            };

            Controls.prototype.dvKensakuJoken = function () {
                return new UZA.Panel(this.convFiledName("dvKensakuJoken"));
            };

            Controls.prototype.txtNenrei = function () {
                return new UZA.TextBoxNumRange(this.convFiledName("txtNenrei"));
            };

            Controls.prototype.txtNenreiKijunbi = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNenreiKijunbi"));
            };

            Controls.prototype.txtSeinengappi = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeinengappi"));
            };

            Controls.prototype.ccdHokenshaList = function () {
                return new DBZ.HokenshaList.ModeController(this.convFiledName("ccdHokenshaList"));
            };

            Controls.prototype.DvChiku = function () {
                return new UZA.Panel(this.convFiledName("DvChiku"));
            };

            Controls.prototype.ddlChikuSelect = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChikuSelect"));
            };

            Controls.prototype.lblStart = function () {
                return new UZA.Label(this.convFiledName("lblStart"));
            };

            Controls.prototype.ccdJushoFrom = function () {
                return new URA.ChoikiInput.ModeController(this.convFiledName("ccdJushoFrom"));
            };

            Controls.prototype.ccdGyoseikuFrom = function () {
                return new URA.GyoseikuInput.ModeController(this.convFiledName("ccdGyoseikuFrom"));
            };

            Controls.prototype.ccdChiku1From = function () {
                return new URA.Chiku1Input.ModeController(this.convFiledName("ccdChiku1From"));
            };

            Controls.prototype.ccdChiku2From = function () {
                return new URA.Chiku2Input.ModeController(this.convFiledName("ccdChiku2From"));
            };

            Controls.prototype.ccdChiku3From = function () {
                return new URA.Chiku3Input.ModeController(this.convFiledName("ccdChiku3From"));
            };

            Controls.prototype.lblEnd = function () {
                return new UZA.Label(this.convFiledName("lblEnd"));
            };

            Controls.prototype.ccdJushoTo = function () {
                return new URA.ChoikiInput.ModeController(this.convFiledName("ccdJushoTo"));
            };

            Controls.prototype.ccdGyoseikuTo = function () {
                return new URA.GyoseikuInput.ModeController(this.convFiledName("ccdGyoseikuTo"));
            };

            Controls.prototype.ccdChiku1To = function () {
                return new URA.Chiku1Input.ModeController(this.convFiledName("ccdChiku1To"));
            };

            Controls.prototype.ccdChiku2To = function () {
                return new URA.Chiku2Input.ModeController(this.convFiledName("ccdChiku2To"));
            };

            Controls.prototype.ccdChiku3To = function () {
                return new URA.Chiku3Input.ModeController(this.convFiledName("ccdChiku3To"));
            };
            return Controls;
        })();
        HanyoListAtenaSelect.Controls = Controls;
    })(DBZ.HanyoListAtenaSelect || (DBZ.HanyoListAtenaSelect = {}));
    var HanyoListAtenaSelect = DBZ.HanyoListAtenaSelect;
})(DBZ || (DBZ = {}));
