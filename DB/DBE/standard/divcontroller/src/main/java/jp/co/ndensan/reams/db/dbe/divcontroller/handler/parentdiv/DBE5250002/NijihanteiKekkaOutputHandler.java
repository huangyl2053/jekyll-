/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525002.DBE525002_HanteiKekkaHokenshaParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.NijihanteiKekkaOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuFinder;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 判定結果情報出力(保険者)の取得するクラスです。
 *
 * @reamsid_L DBE-0190-010 lizhuoxuan
 */
public class NijihanteiKekkaOutputHandler {

    private final NijihanteiKekkaOutputDiv nijidiv;
    private final RString 男 = new RString("key0");
    private final RString 女 = new RString("key1");
    private final RString 判定結果ボタン = new RString("btnRenkeiDataOutput");
    private final RString 連携ボタン = new RString("btnHanteikekkaOutput");

    /**
     * コンストラクタです。
     *
     * @param nijidiv 判定結果情報出力(保険者)
     */
    public NijihanteiKekkaOutputHandler(NijihanteiKekkaOutputDiv nijidiv) {
        this.nijidiv = nijidiv;
    }

    /**
     * 判定結果情報出力(保険者)初期処理する。
     */
    public void initialize() {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(判定結果ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(連携ボタン, false);
        nijidiv.getKensakuJoken().getTxtNijihanteDateRange().setFromValue(RDate.getNowDate());
        nijidiv.getKensakuJoken().getTxtNijihanteDateRange().setToValue(RDate.getNowDate());
        nijidiv.getKensakuJoken().getTxtHyojiDataLimit().setValue(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        List<dgTaishoshaIchiran_Row> dgKoufuKaishuList = new ArrayList<>();
        nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().setDataSource(dgKoufuKaishuList);
        hokenjouhou();
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * 判定結果情報出力(保険者)検索処理する。
     */
    public void kennsaku() {
        List<dgTaishoshaIchiran_Row> dgTaishoshaIchiranList = new ArrayList<>();
        RString fromtime = RString.EMPTY;
        if (nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue() != null) {
            fromtime = new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue().toString());
        }
        RString totime = RString.EMPTY;
        if (nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue() != null) {
            totime = new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue().toString());
        }
        List<RString> 性別区分 = new ArrayList<>();
        List<KeyValueDataSource> 性別 = nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                getNinteiShinseishaFinderDiv().getChkSeibetsu().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 性別) {
            if (男.equals(keyValueDataSource.getKey())) {
                性別区分.add(Gender.MALE.getCode());
            } else if (女.equals(keyValueDataSource.getKey())) {
                性別区分.add(Gender.FEMALE.getCode());
            }
        }

        HanteiKekkaJouhouShuturyokuParameter hanteiParameter = HanteiKekkaJouhouShuturyokuParameter.
                createParam(fromtime,
                        totime,
                        nijidiv.getKensakuJoken().getRadDataShutsuryokuUmu().getSelectedKey(),
                        nijidiv.getKensakuJoken().getRadDataShutsuryokuUmu().getSelectedKey(),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaNumber().getValue(),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHokenshaNumber().getSelectedItem().get証記載保険者番号().getColumnValue(),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShichosonCode().getSelectedKey(),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaName().getValue(),
                        !nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getChkMinashiFlag().getSelectedItems().isEmpty(),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateFrom() == null ? RString.EMPTY
                        : new RString(nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateFrom().getValue().toString()),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateTo() == null ? RString.EMPTY
                        : new RString(nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateTo().getValue().toString()),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getTxtBirthDateFrom() == null ? RString.EMPTY
                        : new RString(nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getTxtBirthDateFrom().getValue().toString()),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getTxtBirthDateTO() == null ? RString.EMPTY
                        : new RString(nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getTxtBirthDateTO().getValue().toString()),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getDdlShinseijiShinseiKubun().getSelectedKey(),
                        false,
                        性別区分,
                        nijidiv.getKensakuJoken().getTxtHyojiDataLimit().getValue().isEmpty() ? new Decimal(0)
                        : new Decimal(nijidiv.getKensakuJoken().getTxtHyojiDataLimit().getValue().toString()),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getDdlHihokenshaNameMatchType().getSelectedKey()
                );
        List<HanteiKekkaJouhouShuturyokuBusiness> ninteiList = HanteiKekkaJouhouShuturyokuFinder.createInstance()
                .getHanteiKekka(hanteiParameter).records();
        if (ninteiList != null && !ninteiList.isEmpty()) {
            for (HanteiKekkaJouhouShuturyokuBusiness jigyoshaInput : ninteiList) {
                dgTaishoshaIchiran_Row dgFukushiyoguShohin = new dgTaishoshaIchiran_Row();
                dgFukushiyoguShohin.getHihokenshaNo().setValue(nullToEmpty(jigyoshaInput.get被保険者番号()));
                dgFukushiyoguShohin.setHihokenshaShimei(nullToEmpty(jigyoshaInput.get被保険者氏名()));
                dgFukushiyoguShohin.setHihokenshaKanaShimei(nullToEmpty(jigyoshaInput.get被保険者カナ氏名()));
                dgFukushiyoguShohin.setSeibetsu(Seibetsu.toValue(jigyoshaInput.get性別()).get名称());
                if (jigyoshaInput.get生年月日() != null) {
                    dgFukushiyoguShohin.getBirthYMD().setValue(new FlexibleDate(jigyoshaInput.get生年月日().toString()));
                }
                dgFukushiyoguShohin.getNinteiShinseiDay().
                        setValue(jigyoshaInput.get認定申請年月日() == null ? FlexibleDate.EMPTY
                                : new FlexibleDate(jigyoshaInput.get認定申請年月日().toString()));
                dgFukushiyoguShohin.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.
                        toValue(jigyoshaInput.get認定申請区分_申請時コード()).get名称());
                if (jigyoshaInput.get二次判定要介護状態区分コード() != null) {
                    dgFukushiyoguShohin.setNijiHanteiKekka(YokaigoJotaiKubun09.toValue(jigyoshaInput.get二次判定要介護状態区分コード()).get名称());
                }
                RStringBuilder 審査会名称 = new RStringBuilder();
                審査会名称.append(new RString("第"));
                審査会名称.append(jigyoshaInput.get開催番号() == null ? RString.EMPTY : jigyoshaInput.get開催番号());
                審査会名称.append(new RString("回審査会"));
                dgFukushiyoguShohin.setKaigoNinteiShinsakaiName(審査会名称.toRString());
                hiduke(dgFukushiyoguShohin, jigyoshaInput);
                dgFukushiyoguShohin.setShinseishoKanriNo(jigyoshaInput.get申請書管理番号());
                dgTaishoshaIchiranList.add(dgFukushiyoguShohin);
                アクセスログ();
            }
        }
        nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().setDataSource(dgTaishoshaIchiranList);
    }

    private void hiduke(dgTaishoshaIchiran_Row dgFukushiyoguShohin, HanteiKekkaJouhouShuturyokuBusiness jigyoshaInput) {
        if (jigyoshaInput.get開催予定日() != null) {
            dgFukushiyoguShohin.getKaisaiYoteiDay().setValue(new FlexibleDate(jigyoshaInput.get開催予定日().toString()));
        }
        if (jigyoshaInput.get開催日() != null) {
            dgFukushiyoguShohin.getKaisaiDay().setValue(new FlexibleDate(jigyoshaInput.get開催日().toString()));
        }
        if (jigyoshaInput.get審査会結果情報抽出年月日() == null) {
            dgFukushiyoguShohin.setDataShutsuryoku(nullToEmpty(jigyoshaInput.get審査会結果情報抽出年月日()));
        } else {
            dgFukushiyoguShohin.setDataShutsuryoku(new RString("済"));
        }
    }

    /**
     * 判定結果情報出力(保険者)作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return DBE525002_HanteiKekkaHokenshaParameter
     */
    public DBE525002_HanteiKekkaHokenshaParameter setBatchParameter() {
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgTaishoshaIchiran_Row row : nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getDataSource()) {
            if (row.getSelected()) {
                shinseishoKanriNo.add(row.getShinseishoKanriNo());
            }
        }
        DBE525002_HanteiKekkaHokenshaParameter hanteibatchParameter
                = new DBE525002_HanteiKekkaHokenshaParameter();
        hanteibatchParameter.setShinseishoKanriNo(shinseishoKanriNo);
        hanteibatchParameter.setNijiHanteiYMDFrom(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue() == null ? RString.EMPTY
                : new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue().toString()));
        hanteibatchParameter.setNijiHanteiYMDTo(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue() == null ? RString.EMPTY
                : new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue().toString()));
        return hanteibatchParameter;
    }

    /**
     * 判定結果情報出力(保険者)作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return DBE525002_HanteiKekkaHokenshaParameter
     */
    public DBE525002_HanteiKekkaHokenshaParameter setCSVBatchParameter() {
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgTaishoshaIchiran_Row row : nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getDataSource()) {
            if (row.getSelected()) {
                shinseishoKanriNo.add(row.getShinseishoKanriNo());
            }
        }
        DBE525002_HanteiKekkaHokenshaParameter hanteibatchParameter
                = new DBE525002_HanteiKekkaHokenshaParameter();
        hanteibatchParameter.setShinseishoKanriNo(shinseishoKanriNo);
        hanteibatchParameter.setNijiHanteiYMDFrom(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue() == null ? RString.EMPTY
                : new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue().toString()));
        hanteibatchParameter.setNijiHanteiYMDTo(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue() == null ? RString.EMPTY
                : new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue().toString()));
        return hanteibatchParameter;
    }

    /**
     * アクセスログを出力します。
     *
     */
    public void アクセスログ() {
        AccessLogger.log(AccessLogType.照会, toPersonalData(ShikibetsuCode.EMPTY));
    }

    private PersonalData toPersonalData(ShikibetsuCode 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号.value());
        return PersonalData.of(申請書管理番号, expandedInfo);
    }

    private void hokenjouhou() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString loginId = controlData.getLoginInfo().getUserId();
        List<AuthorityItem> 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(loginId);
        if (市町村識別ID != null && !市町村識別ID.isEmpty()) {
            KoseiShichosonJoho 市町村情報 = ShichosonSecurityJoho.getKouseiShichosonJoho(市町村識別ID.get(0).getItemId());
            if (市町村情報 != null) {
                nijidiv.getKensakuJoken().getTxtHokenshaNo().setValue(new RString(市町村情報.get証記載保険者番号().toString()));
                nijidiv.getKensakuJoken().getTxtHokenshaName().setValue(市町村情報.get市町村名称());
            }
        }
    }
}
