/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinchokudataoutput.ShinchokuDataOutputBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001.ShinchokuDataOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001.dgShinchokuIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定進捗情報データ出力の処理です。
 *
 * @reamsid_L DBE-1500-010 wanghui
 */
public class ShinchokuDataOutputHandler {

    private final ShinchokuDataOutputDiv div;
    private static final Code 認定ｿﾌﾄ99 = new Code(new RString("99A"));
    private static final Code 認定ｿﾌﾄ2002 = new Code(new RString("02A"));
    private static final Code 認定ｿﾌﾄ2006 = new Code(new RString("06A"));
    private static final Code 認定ｿﾌﾄ2009_A = new Code(new RString("09A"));
    private static final Code 認定ｿﾌﾄ2009_B = new Code(new RString("09B"));

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShinchokuDataOutputHandler(ShinchokuDataOutputDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化です。
     */
    public void intialize() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getRadKubun().setSelectedKey(new RString("0"));
        div.getTxtChuishutsuRange().setFromValue(new RDate(RDate.getNowDate().toString()));
        div.getTxtChuishutsuRange().setToValue(new RDate(RDate.getNowDate().toString()));
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 画面の検索条件入力項目をクリアする。
     */
    public void btnJokenClear() {
        div.getRadKubun().setSelectedKey(new RString("0"));
        div.getTxtChuishutsuRange().clearFromValue();
        div.getTxtChuishutsuRange().clearToValue();
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtHihokenshaCode().clearValue();
        div.getTxtMaxKensu().clearValue();
    }

    /**
     * 対象者一覧編集です。。
     *
     * @param list List<YouKaigoNinteiShinchokuJohouBusiness>
     * @param personalData personalData
     */
    public void setdgShinchokuIchiran(List<YouKaigoNinteiShinchokuJohouBusiness> list, PersonalData personalData) {
        List<dgShinchokuIchiran_Row> dgChosainList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (YouKaigoNinteiShinchokuJohouBusiness business : list) {
                dgShinchokuIchiran_Row row = new dgShinchokuIchiran_Row();
                row.setHihoNo(nullOrEmptv(business.get被保険者番号()));
                row.setName(nullOrEmptv(business.get被保険者氏名()));
                row.setSeibetsu(Seibetsu.toValue(business.get性別()).get名称());
                if (business.get生年月日() != null) {
                    row.getBirthYMD().setValue(new RDate(business.get生年月日().toString()));
                }
                if (business.get認定申請年月日() != null) {
                    row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
                }
                row.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード()).get名称());
                row.setShiseiKubunHorei(NinteiShinseiHoreiCode.toValue(business.get認定申請区分法令コード()).get名称());
                if (!RString.isNullOrEmpty(business.get厚労省IF識別コード())
                        && !RString.isNullOrEmpty(business.get二次判定要介護状態区分コード())) {
                    row.setHanteiKekka(一次判定結果の名称を取得する(new Code(business.get厚労省IF識別コード().toString()),
                            new Code(business.get二次判定要介護状態区分コード().toString())));
                }
                if (!RString.isNullOrEmpty(business.get認定調査依頼年月日())) {
                    row.getNinteiChosaItakuDay().setValue(new RDate(business.get認定調査依頼年月日().toString()));
                }
                if (!RString.isNullOrEmpty(business.get認定調査実施年月日())) {
                    row.getNinteiChosaJisshiDay().setValue(new RDate(business.get認定調査実施年月日().toString()));
                }
                row.setNinteiChosaItakusaki(nullOrEmptv(business.get事業者名称()));
                row.setNinteiChosain(nullOrEmptv(business.get調査員氏名()));
                if (!RString.isNullOrEmpty(business.get主治医意見書受領年月日())) {
                    row.getIkenshoJuryoDay().setValue(new RDate(business.get主治医意見書受領年月日().toString()));
                }
                if (!RString.isNullOrEmpty(business.get要介護認定一次判定年月日())) {
                    row.getIhijiHanteiDay().setValue(new RDate(business.get要介護認定一次判定年月日().toString()));
                }
                if (!RString.isNullOrEmpty(business.get要介護認定一次判定結果コード())) {
                    row.setIchijiHanteiKekka(一次判定結果の名称を取得する(new Code(business.get厚労省IF識別コード().toString()),
                            new Code(business.get要介護認定一次判定結果コード().toString())));
                }
                if (!RString.isNullOrEmpty(business.get介護認定審査会資料作成年月日())) {
                    row.getShinsakaiShiryoSakuseiDay().setValue(new RDate(business.get介護認定審査会資料作成年月日().toString()));
                }
                if (!RString.isNullOrEmpty(business.get介護認定審査会開催予定年月日())) {
                    row.getShinsakaiKaisaiYoteiDay().setValue(new RDate(business.get介護認定審査会開催予定年月日().toString()));
                }
                if (!RString.isNullOrEmpty(business.get介護認定審査会開催年月日())) {
                    row.getShinsakaiKaisaiDay().setValue(new RDate(business.get介護認定審査会開催年月日().toString()));
                }
                row.setShinseishoNo(business.get申請書管理番号());
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                        business.get申請書管理番号()));
                dgChosainList.add(row);
            }
        }
        div.getDgShinchokuIchiran().setDataSource(dgChosainList);
    }

    /**
     * 調査員一覧のパラメタ編集です。
     *
     * @param div HomonChosaItakuNyuryokuDiv
     * @return NinteiChosaHoshuJissekiJohoMybatisParameter
     */
    public YouKaigoNinteiShinchokuJohouParameter createParam(ShinchokuDataOutputDiv div) {
        RString 抽出期間開始日;
        RString 抽出期間終了日;
        RString 証記載保険者番号;
        RString 被保険者番号;
        if (div.getTxtChuishutsuRange().getFromValue() == null) {
            抽出期間開始日 = RString.EMPTY;
        } else {
            抽出期間開始日 = div.getTxtChuishutsuRange().getFromValue().toDateString();
        }
        if (div.getTxtChuishutsuRange().getToValue() == null) {
            抽出期間終了日 = RString.EMPTY;
        } else {
            抽出期間終了日 = div.getTxtChuishutsuRange().getToValue().toDateString();
        }
        if (div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号() == null) {
            証記載保険者番号 = RString.EMPTY;
        } else {
            証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value();
        }
        if (div.getTxtHihokenshaCode() == null) {
            被保険者番号 = RString.EMPTY;
        } else {
            被保険者番号 = div.getTxtHihokenshaCode().getValue();
        }
        return YouKaigoNinteiShinchokuJohouParameter.createParam(
                抽出期間開始日,
                抽出期間終了日,
                証記載保険者番号,
                被保険者番号,
                new Decimal(div.getTxtMaxKensu().getValue().toString()));
    }

    /**
     * 要介護認定進捗情報データ出力のパラメタ編集です。
     *
     * @param div HomonChosaItakuNyuryokuDiv
     * @return ShinchokuDataOutputBatchParamter
     */
    public ShinchokuDataOutputBatchParamter setBatchParamter(ShinchokuDataOutputDiv div) {
        ShinchokuDataOutputBatchParamter batchparamter = new ShinchokuDataOutputBatchParamter();
        List<dgShinchokuIchiran_Row> rowList = div.getDgShinchokuIchiran().getSelectedItems();
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgShinchokuIchiran_Row row : rowList) {

            shinseishoKanriNo.add(row.getShinseishoNo());
        }
        batchparamter.setShinseishoKanriNoList(shinseishoKanriNo);
        batchparamter.setFayirukuben(div.getRadKubun().getSelectedKey());
        return batchparamter;
    }

    private RString 一次判定結果の名称を取得する(Code 厚労省IF識別コード, Code 一次判定結果コード) {

        if (一次判定結果コード != null && !一次判定結果コード.isEmpty()) {
            if (認定ｿﾌﾄ99.equals(厚労省IF識別コード)) {
                return IchijiHanteiKekkaCode99.toValue(一次判定結果コード.getKey()).get名称();
            } else if (認定ｿﾌﾄ2002.equals(厚労省IF識別コード)) {
                return IchijiHanteiKekkaCode02.toValue(一次判定結果コード.getKey()).get名称();
            } else if (認定ｿﾌﾄ2006.equals(厚労省IF識別コード)) {
                return IchijiHanteiKekkaCode06.toValue(一次判定結果コード.getKey()).get名称();
            } else if (認定ｿﾌﾄ2009_A.equals(厚労省IF識別コード)
                    || 認定ｿﾌﾄ2009_B.equals(厚労省IF識別コード)) {
                return IchijiHanteiKekkaCode09.toValue(一次判定結果コード.getKey()).get名称();
            }
        }
        return RString.EMPTY;
    }

    private RString nullOrEmptv(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;

    }
}
