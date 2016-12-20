/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE491001.DBE491001_NichijiShinchokuParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001.ShinchokuDataOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001.dgShinchokuIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

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
    private static final RString 進捗情報 = new RString("0");
    private static final RString 処理名 = new RString("要介護認定申請連携データ取込");
    private static final RString 処理枝番 = new RString("0000");
    private static final RString 年度 = new RString("0000");
    private static final RString 年度内連番 = new RString("0001");

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
    public void onLoad() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getRadKubun().setSelectedKey(進捗情報);
        div.getTxtChuishutsuRange().setFromValue(new RDate(RDate.getNowDate().toString()));
        div.getTxtChuishutsuRange().setToValue(new RDate(RDate.getNowDate().toString()));
        set抽出期間();
    }

    /**
     * 画面の検索条件入力項目をクリアする。
     */
    public void btnJokenClear() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getRadKubun().setSelectedKey(進捗情報);
        div.getTxtChuishutsuRange().setFromValue(new RDate(RDate.getNowDate().toString()));
        div.getTxtChuishutsuRange().setToValue(new RDate(RDate.getNowDate().toString()));
        set抽出期間();
        div.getTxtHihokenshaCode().clearValue();
        div.getTxtShimei().clearValue();
    }

    /**
     * 対象者一覧編集です。。
     *
     * @param list List<YouKaigoNinteiShinchokuJohouBusiness>
     */
    public void setdgShinchokuIchiran(List<YouKaigoNinteiShinchokuJohouBusiness> list) {
        List<dgShinchokuIchiran_Row> dgChosainList = new ArrayList<>();
        for (YouKaigoNinteiShinchokuJohouBusiness business : list) {
            dgShinchokuIchiran_Row row = new dgShinchokuIchiran_Row();
            row.setHihoNo(nullOrEmpty(business.get被保険者番号()));
            row.setName(nullOrEmpty(business.get被保険者氏名()));
            row.setSeibetsu(Seibetsu.toValue(business.get性別()).get名称());
            if (!RString.isNullOrEmpty(business.get生年月日())) {
                row.getBirthYMD().setValue(new RDate(business.get生年月日().toString()));
            }
            if (!RString.isNullOrEmpty(business.get認定申請年月日())) {
                row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
            }
            row.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード()).get名称());
            if (!RString.isNullOrEmpty(business.get認定申請区分法令コード())) {
                row.setShiseiKubunHorei(NinteiShinseiHoreiCode.toValue(business.get認定申請区分法令コード()).get名称());
            }
            if (!RString.isNullOrEmpty(business.get厚労省IF識別コード())
                    && !RString.isNullOrEmpty(business.get二次判定要介護状態区分コード())) {
                row.setHanteiKekka(get要介護状態区分名称取得(new Code(business.get厚労省IF識別コード().toString()),
                        new Code(business.get二次判定要介護状態区分コード().toString())));
            }
            if (!RString.isNullOrEmpty(business.get認定調査依頼年月日())) {
                row.getNinteiChosaItakuDay().setValue(new RDate(business.get認定調査依頼年月日().toString()));
            }
            if (!RString.isNullOrEmpty(business.get認定調査実施年月日())) {
                row.getNinteiChosaJisshiDay().setValue(new RDate(business.get認定調査実施年月日().toString()));
            }
            row.setNinteiChosaItakusaki(nullOrEmpty(business.get事業者名称()));
            row.setNinteiChosain(nullOrEmpty(business.get調査員氏名()));
            if (!RString.isNullOrEmpty(business.get主治医意見書受領年月日())) {
                row.getIkenshoJuryoDay().setValue(new RDate(business.get主治医意見書受領年月日().toString()));
            }
            if (!RString.isNullOrEmpty(business.get要介護認定一次判定年月日())) {
                row.getIhijiHanteiDay().setValue(new RDate(business.get要介護認定一次判定年月日().toString()));
            }
            if (!RString.isNullOrEmpty(business.get要介護認定一次判定結果コード())) {
                row.setIchijiHanteiKekka(get一次判定結果の名称を取得する(new Code(business.get厚労省IF識別コード().toString()),
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
            PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
            personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    business.get申請書管理番号()));
            AccessLogger.log(AccessLogType.照会, personalData);
            dgChosainList.add(row);
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
        if (div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号() == null
                && div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().isEmpty()) {
            証記載保険者番号 = RString.EMPTY;
        } else {
            証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value();
        }
        if (RString.isNullOrEmpty(div.getTxtHihokenshaCode().getValue())) {
            被保険者番号 = RString.EMPTY;
        } else {
            被保険者番号 = div.getTxtHihokenshaCode().getValue();
        }
        return YouKaigoNinteiShinchokuJohouParameter.createParam(
                抽出期間開始日,
                抽出期間終了日,
                証記載保険者番号,
                被保険者番号,
                null);
    }

    /**
     * 要介護認定進捗情報データ出力のパラメタ編集です。
     *
     * @param div HomonChosaItakuNyuryokuDiv
     * @return ShinchokuDataOutputBatchParamter
     */
    public DBE491001_NichijiShinchokuParameter setBatchParamter(ShinchokuDataOutputDiv div) {
        DBE491001_NichijiShinchokuParameter batchparamter = new DBE491001_NichijiShinchokuParameter();
        List<dgShinchokuIchiran_Row> rowList = div.getDgShinchokuIchiran().getSelectedItems();
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgShinchokuIchiran_Row row : rowList) {

            shinseishoKanriNo.add(row.getShinseishoNo());
        }
        batchparamter.setShinseishoKanriNoList(shinseishoKanriNo);
        batchparamter.setFayirukuben(div.getRadKubun().getSelectedKey());
        return batchparamter;
    }
    
    /**
     * 市町村情報変更時の動作。
     */
    public void onChange_ddlSichoson() {
        set抽出期間();
    }
    
    /**
     * 被保険者番号変更時の動作。
     */
    public void onChange_txtHihokenshaCode() {
        set被保険者指名();
    }
    
    private void set抽出期間() {
        DbT7022ShoriDateKanriEntity entity;
        DbT7022ShoriDateKanriDac 処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        LasdecCode 証記載保険者番号;
        div.getTxtZenkaiChuishutsuRange().clearFromValue();
        div.getTxtZenkaiChuishutsuRange().clearToValue();
        if (div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号() == null
                && div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().isEmpty()) {
            証記載保険者番号 = new LasdecCode(RString.EMPTY);
        } else {
            証記載保険者番号 = new LasdecCode(div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value());
        }
        entity = 処理日付管理Dac.select前回の実行情報(SubGyomuCode.DBE認定支援, 証記載保険者番号, 処理名, 処理枝番);
        if (entity == null) {
            div.getTxtChuishutsuRange().setFromValue(RDate.MIN);
            div.getTxtChuishutsuRange().setToValue(RDate.getNowDate());
        } else {
            RDate 前回処理日付From = new RDate(entity.getTaishoKaishiYMD().toString());
            RDate 前回処理日付To = new RDate(entity.getTaishoShuryoYMD().toString());
            div.getTxtZenkaiChuishutsuRange().setFromValue(前回処理日付From);
            div.getTxtZenkaiChuishutsuRange().setToValue(前回処理日付To);
            div.getTxtChuishutsuRange().setFromValue(前回処理日付To.plusDay(1));
            div.getTxtChuishutsuRange().setToValue(RDate.getNowDate());
        }
    }
    
    private void set被保険者指名() {
        RString hihokenshaNo = div.getTxtHihokenshaCode().getValue();
        if (hihokenshaNo != null && !hihokenshaNo.isEmpty()) {
            DbT5101NinteiShinseiJohoDac dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
            DbT5101NinteiShinseiJohoEntity entity = dac.selectByHihokenshaNo(hihokenshaNo);
            if (entity != null) {
                div.getTxtShimei().setValue(entity.getHihokenshaName().getColumnValue());
            }
        }
    }

    private RString get一次判定結果の名称を取得する(Code 厚労省IF識別コード, Code 一次判定結果コード) {

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
        return RString.EMPTY;
    }
    
    private RString get要介護状態区分名称取得(Code 厚労省IF識別コード, Code 要介護状態区分コード) {
        if (認定ｿﾌﾄ99.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun99.toValue(要介護状態区分コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2002.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun02.toValue(要介護状態区分コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2006.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun06.toValue(要介護状態区分コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2009_A.equals(厚労省IF識別コード)
                || 認定ｿﾌﾄ2009_B.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun09.toValue(要介護状態区分コード.getKey()).get名称();
        }
        return RString.EMPTY;
    }

    private RString nullOrEmpty(RString obj) {
        if (RString.isNullOrEmpty(obj)) {
            return RString.EMPTY;
        }
        return obj;

    }
}
