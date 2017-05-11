/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2920001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.iraijohodatatorikomi.NinteiShinseiJohoIraiJohoData;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.orca.IraiJohoDataTorikomiCsvData;
import jp.co.ndensan.reams.db.dbe.business.core.orca.IraiJohoDataTorikomiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.IraiJohoDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.dgTorikomiFileIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 依頼情報データ受取（オルカ）のHandlerクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
public class IraiJohoDataTorikomiHandler {

    private static final int INT_10 = 10;
    private static final RString 同意する = new RString("1");
    private static final RString 有 = new RString("1");
    private final IraiJohoDataTorikomiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IraiJohoDataTorikomiDiv
     */
    public IraiJohoDataTorikomiHandler(IraiJohoDataTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 一覧エリアの設定処理です。
     *
     * @param csvEntityList {@link IraiJohoDataTorikomiCsvData}
     */
    public void set一覧エリア(IraiJohoDataTorikomiCsvData csvEntityList) {
        List<dgTorikomiFileIchiran_Row> rowlist = new ArrayList<>();
        List<KeyValueDataSource> selectedKeyItems = new ArrayList<>();
        selectedKeyItems.add(new KeyValueDataSource(new RString(0), RString.EMPTY));
        for (IraiJohoDataTorikomiCsvEntity csvEntity : csvEntityList) {
            dgTorikomiFileIchiran_Row row1 = new dgTorikomiFileIchiran_Row();
            row1.setHokenshaBango(csvEntity.get保険者番号());
            row1.setHihokenshaBango(!RString.isNullOrEmpty(csvEntity.get被保険者番号())
                    ? csvEntity.get被保険者番号().padZeroToLeft(INT_10) : RString.EMPTY);
            row1.getShinseibi().setValue(new FlexibleDate(csvEntity.get申請日()));
            row1.setHihokenshaShimei(csvEntity.get患者名());
            row1.getSeninengapi().setValue(new FlexibleDate(csvEntity.get生年月日()));
            row1.setSeibetu(Seibetsu.toValue(csvEntity.get性別()).get名称());
            row1.setYubinBangou(csvEntity.get郵便番号());
            row1.setJyusyo(csvEntity.get住所());
            row1.setIryouKikanMei(csvEntity.get医療機関名());
            row1.setShuziiMei(csvEntity.get医師氏名());
            row1.setKiguusuu(new RString("1"));
            row1.getCheckBox().setDataSource(selectedKeyItems);
            rowlist.add(row1);
            dgTorikomiFileIchiran_Row row2 = new dgTorikomiFileIchiran_Row();
            row2.setKiguusuu(new RString("0"));
            row2.getCheckBox().setDataSource(selectedKeyItems);
            row2.getCheckBox().setVisible(false);
            rowlist.add(row2);
        }
        div.getDgTorikomiFileIchiran().setDataSource(rowlist);

        div.getUploadArea().setIsOpen(false);
        div.getPanelIchiran().setDisplayNone(false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("nyuryokuCyeku"), true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("insatu"), true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("koushin"), true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("nyuryokuCyeku"), false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("insatu"), true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("koushin"), true);
    }

    /**
     * 一覧エリアの設定処理です。
     *
     * @param ninteiShinseiJohoList List<NinteiShinseiJohoIraiJohoData>
     */
    public void set一覧エリア_入力チェック(List<NinteiShinseiJohoIraiJohoData> ninteiShinseiJohoList) {
        List<dgTorikomiFileIchiran_Row> rowlist = new ArrayList<>();
        List<dgTorikomiFileIchiran_Row> rowList = div.getDgTorikomiFileIchiran().getDataSource();
        for (int i = 0; i < ninteiShinseiJohoList.size(); i++) {
            /* 奇数行…非表示項目の設定のみ */
            dgTorikomiFileIchiran_Row row1 = rowList.get(2 * i);
            row1.setShinseishoKanriNo(nullToEmpty(ninteiShinseiJohoList.get(i).get申請書管理番号()));
            row1.setKoroshoIfShikibetsuCode(nullToEmpty(ninteiShinseiJohoList.get(i).get厚労省IF識別コード()));
            row1.getIkenshoIraiRirekiNo().setValue(new Decimal(ninteiShinseiJohoList.get(i).get主治医意見書作成依頼履歴番号()));
            row1.setShujiiCode(ninteiShinseiJohoList.get(i).get主治医コード());
            row1.setShujiiIryokikanCode(ninteiShinseiJohoList.get(i).get主治医医療機関コード());
            rowlist.add(row1);
            /* 偶数行 */
            dgTorikomiFileIchiran_Row row2 = rowList.get(2 * i + 1);
            row2.setHokenshaBango(nullToEmpty(ninteiShinseiJohoList.get(i).get保険者番号()));
            row2.setHihokenshaBango(nullToEmpty(!RString.isNullOrEmpty(ninteiShinseiJohoList.get(i).get被保険者番号())
                    ? ninteiShinseiJohoList.get(i).get被保険者番号().padZeroToLeft(INT_10) : RString.EMPTY));
            row2.getShinseibi().setValue(new FlexibleDate(ninteiShinseiJohoList.get(i).get認定申請年月日()));
            row2.setHihokenshaShimei(nullToEmpty(ninteiShinseiJohoList.get(i).get被保険者氏名()));
            row2.getSeninengapi().setValue(new FlexibleDate(ninteiShinseiJohoList.get(i).get生年月日()));
            row2.setSeibetu(nullToEmpty(ninteiShinseiJohoList.get(i).get性別()));
            row2.setYubinBangou(nullToEmpty(ninteiShinseiJohoList.get(i).get郵便番号()));
            row2.setJyusyo(nullToEmpty(ninteiShinseiJohoList.get(i).get住所()));
            row2.setIryouKikanMei(nullToEmpty(ninteiShinseiJohoList.get(i).get医療機関名称()));
            row2.setShuziiMei(nullToEmpty(ninteiShinseiJohoList.get(i).get主治医氏名()));
            row2.setShinseishoKanriNo(nullToEmpty(ninteiShinseiJohoList.get(i).get申請書管理番号()));
            row2.setKoroshoIfShikibetsuCode(nullToEmpty(ninteiShinseiJohoList.get(i).get厚労省IF識別コード()));
            row2.getIkenshoIraiRirekiNo().setValue(new Decimal(ninteiShinseiJohoList.get(i).get主治医意見書作成依頼履歴番号()));
            row2.setShujiiCode(ninteiShinseiJohoList.get(i).get主治医コード());
            row2.setShujiiIryokikanCode(ninteiShinseiJohoList.get(i).get主治医医療機関コード());
            rowlist.add(row2);
        }
        div.getDgTorikomiFileIchiran().getDataSource().clear();
        div.getDgTorikomiFileIchiran().setDataSource(rowlist);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("insatu"), false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("koushin"), false);
    }

    private static RString nullToEmpty(RString 項目) {
        if (RString.isNullOrEmpty(項目)) {
            return RString.EMPTY;
        }
        return 項目;
    }

    /**
     * 帳票出力用情報を編集する。
     *
     * @param csvEntity IraiJohoDataTorikomiCsvEntity
     * @return IkenshokinyuyoshiBusiness
     */
    public IkenshokinyuyoshiBusiness 帳票出力用情報の編集(IraiJohoDataTorikomiCsvEntity csvEntity) {
        IkenshokinyuyoshiBusiness business = new IkenshokinyuyoshiBusiness(csvEntity);
        return business;
    }

}
