/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0071011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.taishoshakensakubusiness.TaishoshaKensakuRelateBusiness;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 「過誤申立決定情報照会」のHandlerクラスです。
 *
 * @reamsid_L DBC-2940-010 jinjue
 */
public class KetteijohoHandler {

    private final KetteijohoDiv div;
    private static final RString 広域 = new RString("111");
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString 市町村識別ID_01 = new RString("01");
    private static final RString 市町村識別ID_99 = new RString("99");
    private static final RString キー = new RString("000000");
    private static final RString 保険者区分_1 = new RString("1");
    private static final RString 保険者区分_3 = new RString("3");
    private static final RString 保険者区分_2 = new RString("2");
    private static final RString 保険者区分_4 = new RString("4");
    private static final RString 保険者区分_5 = new RString("5");
    private static final RString 公費受給者番号 = new RString("txtKohiJukyushaNo");
    private static final RString 公費負担者番号 = new RString("txtKohiFutanshaNo");

    /**
     * コンストラクタです。
     *
     * @param div KetteijohoDiv
     */
    public KetteijohoHandler(KetteijohoDiv div) {
        this.div = div;
    }

    /**
     * 過誤申立決定情報照会を初期化です。
     *
     * @param 市町村情報 市町村情報
     * @param 市町村識別ID 市町村識別ID
     * @param 構成市町村 構成市町村
     */
    public void onLoad(ShichosonSecurityJoho 市町村情報, List<AuthorityItem> 市町村識別ID, List<KoikiZenShichosonJoho> 構成市町村) {
        if (広域.equals(市町村情報.get導入形態コード().value())) {
            div.getDdlShichosonName().setDisplayNone(false);
            div.getDdlShichosonName().setVisible(true);
        }
        List<KeyValueDataSource> list = new ArrayList<>();
        if (!市町村識別ID.isEmpty() && 市町村識別ID_00.equals(市町村識別ID.get(0).getItemId())) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(キー);
            keyValue.setValue(new RString("000000 全市町村"));
            list.add(keyValue);
            for (KoikiZenShichosonJoho koikiZen : 構成市町村) {
                if (!new RString("0").equals(koikiZen.get所得引出方法())) {
                    KeyValueDataSource key = new KeyValueDataSource();
                    RStringBuilder builder = new RStringBuilder();
                    builder.append(koikiZen.get市町村コード().value());
                    builder.append(RString.HALF_SPACE);
                    builder.append(koikiZen.get市町村名称());
                    key.setKey(koikiZen.get市町村コード().value());
                    key.setValue(builder.toRString());
                    list.add(key);
                }
            }
        }
        if (!市町村識別ID.isEmpty() && (市町村識別ID_01.equals(市町村識別ID.get(0).getItemId())
                || 市町村識別ID_99.equals(市町村識別ID.get(0).getItemId()))) {
            KeyValueDataSource key = new KeyValueDataSource();
            RStringBuilder builder = new RStringBuilder();
            builder.append(市町村情報.get市町村情報().get市町村コード().value());
            builder.append(RString.HALF_SPACE);
            builder.append(市町村情報.get市町村情報().get市町村名称());
            key.setKey(市町村情報.get市町村情報().get市町村コード().value());
            key.setValue(builder.toRString());
            list.add(key);
        }
        div.getDdlShichosonName().setDataSource(list);
        if (!list.isEmpty()) {
            div.getDdlShichosonName().setSelectedKey(list.get(0).getKey());
        }
        if (!div.getDdlShichosonName().getDataSource().isEmpty() && !キー.equals(div.getDdlShichosonName().getDataSource().get(0).getKey())) {
            div.getBtnKohoFutanshaJoho().setDisabled(true);
            div.getBtnSogojigyohiKohiFutanshaJoho().setDisabled(true);
        }
        div.getDdlRirekiNo1().setDataSource(new ArrayList<KeyValueDataSource>());
        div.getDgKagoKetteiDetail().setDataSource(new ArrayList<dgKagoKetteiDetail_Row>());
    }

    /**
     * 過誤申立決定情報照会を取得です。
     *
     * @param 保険者Business 保険者情報
     * @param 総合保険者Business 総合保険者情報
     * @param 公費負担者Business 公費負担者情報
     * @param 経過措置Business 総合事業費経過措置保険者情報
     * @param 総合公費負担者Business 総合公費負担者情報
     * @param 履歴番号Business 履歴番号情報
     * @return List<TaishoshaKensakuRelateBusiness> 過誤決定情報
     */
    public List<TaishoshaKensakuRelateBusiness> onClick_btnSearch(List<TaishoshaKensakuRelateBusiness> 保険者Business,
            List<TaishoshaKensakuRelateBusiness> 公費負担者Business, List<TaishoshaKensakuRelateBusiness> 経過措置Business,
            List<TaishoshaKensakuRelateBusiness> 総合事業費保険者Business, List<TaishoshaKensakuRelateBusiness> 総合事業費公費負担者Business,
            List<TaishoshaKensakuRelateBusiness> 履歴番号Business) {
        List<TaishoshaKensakuRelateBusiness> 過誤決定情報 = new ArrayList<>();
        if (!保険者Business.isEmpty()) {
            get過誤決定情報(保険者Business, 保険者区分_1, 履歴番号Business);
            過誤決定情報 = 保険者Business;
        }
        if (保険者Business.isEmpty() && !経過措置Business.isEmpty()) {
            get過誤決定情報(経過措置Business, 保険者区分_3, 履歴番号Business);
            過誤決定情報 = 経過措置Business;
        }
        if (保険者Business.isEmpty() && 経過措置Business.isEmpty() && !総合事業費保険者Business.isEmpty()) {
            get過誤決定情報(総合事業費保険者Business, 保険者区分_4, 履歴番号Business);
            過誤決定情報 = 総合事業費保険者Business;
        }
        if (保険者Business.isEmpty() && 経過措置Business.isEmpty() && 総合事業費保険者Business.isEmpty() && !公費負担者Business.isEmpty()) {
            get過誤決定情報(公費負担者Business, 保険者区分_2, 履歴番号Business);
            過誤決定情報 = 公費負担者Business;
        }
        if (保険者Business.isEmpty() && 経過措置Business.isEmpty() && 総合事業費保険者Business.isEmpty() && 公費負担者Business.isEmpty()
                && !総合事業費公費負担者Business.isEmpty()) {
            get過誤決定情報(総合事業費公費負担者Business, 保険者区分_5, 履歴番号Business);
            過誤決定情報 = 総合事業費公費負担者Business;
        }
        return 過誤決定情報;
    }

    /**
     * 保険者情報を取得です。
     *
     * @param 過誤決定情報 過誤決定情報
     * @param 保険者区分 保険者区分
     * @param 履歴番号Business 履歴番号情報
     */
    public void set過誤決定情報(List<TaishoshaKensakuRelateBusiness> 過誤決定情報, RString 保険者区分,
            List<TaishoshaKensakuRelateBusiness> 履歴番号Business) {
        if (!過誤決定情報.isEmpty()) {
            get過誤決定情報(過誤決定情報, 保険者区分, 履歴番号Business);
        } else {
            get過誤決定(保険者区分);
        }
    }

    private void get過誤決定(RString 保険者区分) {
        div.getDdlRirekiNo1().setDataSource(new ArrayList<KeyValueDataSource>());
        div.getDgKagoKetteiDetail().setDataSource(new ArrayList<dgKagoKetteiDetail_Row>());
        div.setKubunn(保険者区分);
        if (保険者区分_2.equals(保険者区分) || 保険者区分_5.equals(保険者区分)) {
            div.getDgKagoKetteiDetail().getGridSetting().getColumn(公費受給者番号).setVisible(true);
            div.getDgKagoKetteiDetail().getGridSetting().getColumn(公費負担者番号).setVisible(true);
            div.getLblKetteihokenshaTanisuHiyogaku().setText(new RString("単位数"));
            div.getLblKetteihokenshaHokenshaFutangaku().setText(new RString("公費負担額"));
        } else {
            div.getDgKagoKetteiDetail().getGridSetting().getColumn(公費受給者番号).setVisible(false);
            div.getDgKagoKetteiDetail().getGridSetting().getColumn(公費負担者番号).setVisible(false);
        }
        if (保険者区分_3.equals(保険者区分) || 保険者区分_4.equals(保険者区分) || 保険者区分_5.equals(保険者区分)) {
            div.getLblKetteihokenshaKaigokyuhuhi().setText(new RString("介護予防・日常生活支援総合事業費"));
            div.getTxtHokenshaCell21().setVisible(false);
            div.getTxtHokenshaCell22().setVisible(false);
            div.getTxtHokenshaCell23().setVisible(false);
            div.getTxtHokenshaCell31().setVisible(false);
            div.getTxtHokenshaCell32().setVisible(false);
            div.getTxtHokenshaCell33().setVisible(false);
        } else {
            div.getLblKetteihokenshaKaigokyuhuhi().setText(new RString("介護給付費"));
            div.getTxtHokenshaCell21().setVisible(true);
            div.getTxtHokenshaCell22().setVisible(true);
            div.getTxtHokenshaCell23().setVisible(true);
            div.getTxtHokenshaCell31().setVisible(true);
            div.getTxtHokenshaCell32().setVisible(true);
            div.getTxtHokenshaCell33().setVisible(true);
        }
        div.getTxtKetteiHokenshaSakuseiYMD().clearValue();
        div.getDdlRirekiNo1().setDataSource(new ArrayList<KeyValueDataSource>());
        div.getTxtHokenshaCell11().clearValue();
        div.getTxtHokenshaCell12().clearValue();
        div.getTxtHokenshaCell13().clearValue();
        div.getTxtHokenshaCell21().clearValue();
        div.getTxtHokenshaCell22().clearValue();
        div.getTxtHokenshaCell23().clearValue();
        div.getTxtHokenshaCell31().clearValue();
        div.getTxtHokenshaCell32().clearValue();
        div.getTxtHokenshaCell33().clearValue();
    }

    private void get過誤決定情報(List<TaishoshaKensakuRelateBusiness> 過誤決定情報, RString 保険者区分,
            List<TaishoshaKensakuRelateBusiness> 履歴番号Business) {
        List<KeyValueDataSource> list = new ArrayList<>();
        if (!履歴番号Business.isEmpty()) {
            for (TaishoshaKensakuRelateBusiness 履歴番号 : 履歴番号Business) {
                if (保険者区分.equals(履歴番号.get保険者区分_再())) {
                    KeyValueDataSource key = new KeyValueDataSource();
                    key.setKey(new RString(履歴番号.get履歴番号_再().intValue()));
                    key.setValue(new RString(履歴番号.get履歴番号_再().intValue()));
                    list.add(key);
                }
            }
        }
        div.getDdlRirekiNo1().setDataSource(list);
        if (!list.isEmpty()) {
            div.getDdlRirekiNo1().setSelectedKey(list.get(0).getKey());
        }
        List<dgKagoKetteiDetail_Row> rowList = new ArrayList<>();
        div.setKubunn(保険者区分);
        if (!RString.isNullOrEmpty(new RString(過誤決定情報.get(0).get作成年月日().toString()))) {
            div.getTxtKetteiHokenshaSakuseiYMD().setValue(new RDate(過誤決定情報.get(0).get作成年月日().toString()));
        }
        if (保険者区分_2.equals(保険者区分) || 保険者区分_5.equals(保険者区分)) {
            div.getDgKagoKetteiDetail().getGridSetting().getColumn(公費受給者番号).setVisible(true);
            div.getDgKagoKetteiDetail().getGridSetting().getColumn(公費負担者番号).setVisible(true);
            div.getLblKetteihokenshaTanisuHiyogaku().setText(new RString("単位数"));
            div.getLblKetteihokenshaHokenshaFutangaku().setText(new RString("公費負担額"));
        } else {
            div.getDgKagoKetteiDetail().getGridSetting().getColumn(公費受給者番号).setVisible(false);
            div.getDgKagoKetteiDetail().getGridSetting().getColumn(公費負担者番号).setVisible(false);
        }
        if (保険者区分_3.equals(保険者区分) || 保険者区分_4.equals(保険者区分) || 保険者区分_5.equals(保険者区分)) {
            div.getLblKetteihokenshaKaigokyuhuhi().setText(new RString("介護予防・日常生活支援総合事業費"));
            div.getTxtHokenshaCell21().setVisible(false);
            div.getTxtHokenshaCell22().setVisible(false);
            div.getTxtHokenshaCell23().setVisible(false);
            div.getTxtHokenshaCell31().setVisible(false);
            div.getTxtHokenshaCell32().setVisible(false);
            div.getTxtHokenshaCell33().setVisible(false);
        } else {
            div.getLblKetteihokenshaKaigokyuhuhi().setText(new RString("介護給付費"));
            div.getTxtHokenshaCell21().setVisible(true);
            div.getTxtHokenshaCell22().setVisible(true);
            div.getTxtHokenshaCell23().setVisible(true);
            div.getTxtHokenshaCell31().setVisible(true);
            div.getTxtHokenshaCell32().setVisible(true);
            div.getTxtHokenshaCell33().setVisible(true);
        }
        div.getTxtHokenshaCell11().setValue(new Decimal(過誤決定情報.get(0).get介護給付費件数()));
        div.getTxtHokenshaCell12().setValue(過誤決定情報.get(0).get介護給付費単位数());
        div.getTxtHokenshaCell13().setValue(過誤決定情報.get(0).get介護給付費保険者負担額());
        div.getTxtHokenshaCell21().setValue(new Decimal(過誤決定情報.get(0).get高額介護サービス費件数()));
        div.getTxtHokenshaCell22().setValue(過誤決定情報.get(0).get高額介護サービス費単位数());
        div.getTxtHokenshaCell23().setValue(過誤決定情報.get(0).get高額介護サービス費保険者負担額());
        div.getTxtHokenshaCell31().setValue(new Decimal(過誤決定情報.get(0).get特定入所者介護サービス費等件数()));
        div.getTxtHokenshaCell32().setValue(過誤決定情報.get(0).get特定入所者介護サービス費等費用額());
        div.getTxtHokenshaCell33().setValue(過誤決定情報.get(0).get高額介護サービス費保険者負担額());
        for (TaishoshaKensakuRelateBusiness 一覧明細 : 過誤決定情報) {
            dgKagoKetteiDetail_Row row = new dgKagoKetteiDetail_Row();
            row.setTxtKohiJigyoshaNo(一覧明細.get事業所番号().getColumnValue());
            row.setTxtKohiJigyoshaName(一覧明細.get事業所名());
            row.setTxtKohiHihoNo(一覧明細.get被保険者番号().getColumnValue());
            row.setTxtKohiHihoName(一覧明細.get被保険者氏名());
            row.setTxtKohiMoshitateRiyuCode(一覧明細.get過誤申立事由コード().getColumnValue());
            row.setTxtKohiStyle(一覧明細.getコード略称());
            row.setTxtKohiMoshitateRiyu(一覧明細.get過誤申立事由());
            row.setTxtKohiServiceTeikyoYM(一覧明細.getサービス提供年月().toDateString());
            row.setTxtKohiServiceTypeCode(一覧明細.getサービス種類コード().getColumnValue());
            row.setTxtKohiServiceType(一覧明細.getサービス種類名());
            row.getTxtKohiTanisu().setValue(一覧明細.get単位数());
            row.getTxtKohiFutangaku().setValue(一覧明細.get保険者負担額());
            row.setTxtKohiJukyushaNo(一覧明細.get公費受給者番号());
            row.setTxtKohiFutanshaNo(一覧明細.get公費負担者番号());
            row.setTxtHokenshaShokisaiHokenshaNo(一覧明細.get証記載保険者番号().getColumnValue());
            rowList.add(row);
            アクセスログ(一覧明細.get被保険者番号().getColumnValue());
        }
        div.getDgKagoKetteiDetail().setDataSource(rowList);
    }

    /**
     * 市町村指定DDL表示制御を変更です。
     *
     */
    public void onChange_Shichousonn() {
        if (キー.equals(div.getDdlShichosonName().getSelectedKey())) {
            div.getBtnKohoFutanshaJoho().setVisible(true);
            div.getBtnSogojigyohiKohiFutanshaJoho().setVisible(true);
        } else {
            div.getBtnKohoFutanshaJoho().setVisible(false);
            div.getBtnSogojigyohiKohiFutanshaJoho().setVisible(false);
        }
    }

    /**
     * アクセスログを出力です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void アクセスログ(RString 被保険者番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号));
    }

    private PersonalData toPersonalData(RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
