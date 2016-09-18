package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuDialogButton;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.ArrayList;
import jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.ShoKaishuKirokuDialog.ShoKaishuKirokuRowData;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.dgKoufuKaishu_Row;
import jp.co.ndensan.reams.db.dba.service.core.shokofukaishujoho.ShoKofuKaishuJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishuBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishuIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ShoKaishuKirokuState;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * ShoKaishuKirokuDialogButton のクラスファイル
 *
 * @author 自動生成
 */
public class ShoKaishuKirokuDialogButtonDiv extends Panel implements IShoKaishuKirokuDialogButtonDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShoKaishu")
    private ButtonDialog btnShoKaishu;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("gridData")
    private RString gridData;
    @JsonProperty("saveData")
    private RString saveData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShoKaishu
     * @return btnShoKaishu
     */
    @JsonProperty("btnShoKaishu")
    public ButtonDialog getBtnShoKaishu() {
        return btnShoKaishu;
    }

    /*
     * setbtnShoKaishu
     * @param btnShoKaishu btnShoKaishu
     */
    @JsonProperty("btnShoKaishu")
    public void setBtnShoKaishu(ButtonDialog btnShoKaishu) {
        this.btnShoKaishu = btnShoKaishu;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * getmode
     * @return mode
     */
    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    /*
     * setmode
     * @param mode mode
     */
    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    /*
     * getgridData
     * @return gridData
     */
    @JsonProperty("gridData")
    public RString getGridData() {
        return gridData;
    }

    /*
     * setgridData
     * @param gridData gridData
     */
    @JsonProperty("gridData")
    public void setGridData(RString gridData) {
        this.gridData = gridData;
    }

    /*
     * getsaveData
     * @return saveData
     */
    @JsonProperty("saveData")
    public RString getSaveData() {
        return saveData;
    }

    /*
     * setsaveData
     * @param saveData saveData
     */
    @JsonProperty("saveData")
    public void setSaveData(RString saveData) {
        this.saveData = saveData;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(HihokenshaNo hihokenshaNo, ShoKaishuKirokuState state) {
        this.setHihokenshaNo(hihokenshaNo.getColumnValue());
        this.setMode(state.getStateValue());
    }

    @Override
    public int save() {
        if (this.getHihokenshaNo() == null || this.getHihokenshaNo().isEmpty()
                || this.getGridData() == null || this.getGridData().isEmpty()
                || this.getSaveData() == null || this.getSaveData().isEmpty()) {
            return 0;
        }

        ArrayList<dgKoufuKaishu_Row> listRow = new ArrayList<>();
        ArrayList<ShoKaishuKirokuRowData> rowDataList = DataPassingConverter.deserialize(this.getGridData(), ArrayList.class);
        for (ShoKaishuKirokuRowData rowData : rowDataList) {
            dgKoufuKaishu_Row row = ShoKaishuKirokuRowData.toRow(rowData);
            listRow.add(row);
        }
        Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> 証交付回収情報Model = DataPassingConverter.deserialize(this.getSaveData(), Models.class);

        int saveNum = 0;
        for (dgKoufuKaishu_Row dgKoufuKaishu : listRow) {
            ShoKofuKaishuIdentifier key = new ShoKofuKaishuIdentifier(
                    new HihokenshaNo(this.getHihokenshaNo()),
                    dgKoufuKaishu.getKoufuTypeNo(), Integer.valueOf(dgKoufuKaishu.getRirekiNo().toString()));

            ShoKofuKaishu shoKofuKaishu = 証交付回収情報Model.get(key);
            ShoKofuKaishuBuilder builder = shoKofuKaishu.createBuilderForEdit();

            if (ViewExecutionStatus.Add.get名称().equals(dgKoufuKaishu.getStatus())) {
                builder.set交付年月日(dgKoufuKaishu.getKoufuDate().getValue() != null
                        ? new FlexibleDate(dgKoufuKaishu.getKoufuDate().getValue().toDateString())
                        : FlexibleDate.EMPTY);
                builder.set有効期限(dgKoufuKaishu.getYukoKigen().getValue() != null
                        ? new FlexibleDate(dgKoufuKaishu.getYukoKigen().getValue().toDateString())
                        : FlexibleDate.EMPTY);
                builder.set交付事由(dgKoufuKaishu.getKoufuJiyuNo());
                builder.set交付理由(dgKoufuKaishu.getKofuRiyu());
                builder.set回収年月日(dgKoufuKaishu.getKaishuDate().getValue() != null
                        ? new FlexibleDate(dgKoufuKaishu.getKaishuDate().getValue().toDateString())
                        : FlexibleDate.EMPTY);
                builder.set回収事由(dgKoufuKaishu.getKaishuJiyuNo());
                builder.set回収理由(dgKoufuKaishu.getKaishuRiyu());
                builder.set発行処理日時(YMDHMS.now());
                boolean isAdded = ShoKofuKaishuJohoManager.createInstance().証交付回収情報の追加(builder.build());
                saveNum = isAdded ? saveNum++ : saveNum;
            }
            if (ViewExecutionStatus.Modify.get名称().equals(dgKoufuKaishu.getStatus())) {
                builder.set交付年月日(dgKoufuKaishu.getKoufuDate().getValue() != null
                        ? new FlexibleDate(dgKoufuKaishu.getKoufuDate().getValue().toDateString())
                        : FlexibleDate.EMPTY);
                builder.set有効期限(dgKoufuKaishu.getYukoKigen().getValue() != null
                        ? new FlexibleDate(dgKoufuKaishu.getYukoKigen().getValue().toDateString())
                        : FlexibleDate.EMPTY);
                builder.set交付事由(dgKoufuKaishu.getKoufuJiyuNo());
                builder.set交付理由(dgKoufuKaishu.getKofuRiyu());
                builder.set回収年月日(dgKoufuKaishu.getKaishuDate().getValue() != null
                        ? new FlexibleDate(dgKoufuKaishu.getKaishuDate().getValue().toDateString())
                        : FlexibleDate.EMPTY);
                builder.set回収事由(dgKoufuKaishu.getKaishuJiyuNo());
                builder.set回収理由(dgKoufuKaishu.getKaishuRiyu());
                builder.set発行処理日時(YMDHMS.now());
                boolean isModified = ShoKofuKaishuJohoManager.createInstance().証交付回収情報の更新(builder.build());
                saveNum = isModified ? saveNum++ : saveNum;
            }
            if (ViewExecutionStatus.Delete.get名称().equals(dgKoufuKaishu.getStatus())) {
                builder.set論理削除フラグ(true);
                boolean isDeleted = ShoKofuKaishuJohoManager.createInstance().証交付回収情報の削除(builder.build());
                saveNum = isDeleted ? saveNum++ : saveNum;
            }
        }
        return saveNum;
    }

}
