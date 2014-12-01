var DBA;
(function (DBA) {
    (function (ShoKaishuJokyoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuJokyoList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShoKaishuJokyoList.ModeController = ModeController;
    })(DBA.ShoKaishuJokyoList || (DBA.ShoKaishuJokyoList = {}));
    var ShoKaishuJokyoList = DBA.ShoKaishuJokyoList;
})(DBA || (DBA = {}));
