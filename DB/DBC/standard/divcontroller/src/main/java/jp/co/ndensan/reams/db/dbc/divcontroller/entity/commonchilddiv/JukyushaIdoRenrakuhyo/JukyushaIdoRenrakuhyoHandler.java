/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyoBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_NijiyoboJigyoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ShokiboKyotakuServiceRIyoCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_kohiFutanJogengakuGengakuUmu;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyotoroku.JukyushaTeiseiRenrakuhyoToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 受給者異動連絡票関連共有子Divのハンドラクラスです。
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public class JukyushaIdoRenrakuhyoHandler {

    private final JukyushaIdoRenrakuhyoDiv div;
    private static final RString 空KEY = new RString("space");
    private static final RString 星 = new RString("*");
    private static final RString 新規モード = new RString("新規モード");
    private static final RString 訂正モード = new RString("訂正モード");
    private static final RString 再発行モード = new RString("再発行モード");
    private static final RString 照会モード = new RString("照会モード");
    private static final RString 居宅サービス_旧訪問通所 = new RString("居宅サービス（旧訪問通所）");
    private static final RString 旧短期入所サービス = new RString("（旧短期入所サービス）");
    private static final RString WIDTH = new RString("220");
    private static final int INT_1 = 1;

    /**
     * コンストラクタです。
     *
     *
     * @param div JukyushaIdoRenrakuhyoDiv
     */
    public JukyushaIdoRenrakuhyoHandler(JukyushaIdoRenrakuhyoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     *
     * @return JukyushaIdoRenrakuhyoHandler
     */
    public static JukyushaIdoRenrakuhyoHandler of(JukyushaIdoRenrakuhyoDiv div) {
        return new JukyushaIdoRenrakuhyoHandler(div);
    }

    /**
     * 初期化のメソッドです。
     *
     * @param 処理モード RString
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 int
     * @param 論理削除フラグ boolean
     * @param 異動日 FlexibleDate
     *
     * @return JukyushaIdoRenrakuhyo
     */
    public JukyushaIdoRenrakuhyo initialize(RString 処理モード, ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号,
            int 履歴番号, boolean 論理削除フラグ, FlexibleDate 異動日) {
        div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().setDataSource(create異動事由DropDownList());
        div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setDataSource(create状態区分DropDownList());
        setDivModel(処理モード, 異動日, 履歴番号);
        set支給限度基準額エリア項目名称(異動日);
        div.setHihokenshaNo(DataPassingConverter.serialize(被保険者番号));
        JukyushaIdoRenrakuhyo 受給者異動情報 = JukyushaTeiseiRenrakuhyoToroku.createInstance().
                getJukyushaIdoJoho(処理モード, 識別コード, 被保険者番号, 履歴番号, 論理削除フラグ, 異動日);
        if (受給者異動情報 == null) {
            return 受給者異動情報;
        }
        if (新規モード.equals(処理モード)) {
            if (受給者異動情報.get証記載保険者番号() != null) {
                div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShoKisaiHokenshaNo().setValue(受給者異動情報.get証記載保険者番号().value());
            }
            if (受給者異動情報.get広域連合_政令市_保険者番号() != null) {
                div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtKoikiHokenshaNo().setValue(受給者異動情報.get広域連合_政令市_保険者番号().value());
            }
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNo().setValue(被保険者番号.value());
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().setValue(受給者異動情報.get異動年月日());
            if (受給者異動情報.get性別コード() != null) {
                div.getJukyushaIdoRenrakuhyoKihonJoho().getRadSeibetsu().setSelectedKey(受給者異動情報.get性別コード());
            }
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNameKana().setValue(受給者異動情報.get被保険者氏名カナ());
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtUmareYMD().setValue(受給者異動情報.get生年月日());
            if (受給者異動情報.get訂正年月日() != null && !受給者異動情報.get訂正年月日().isEmpty()) {
                div.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD().setValue(new RDate(受給者異動情報.get訂正年月日().toString()));
            }
            return 受給者異動情報;
        }
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().setValue(受給者異動情報.get異動年月日());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getRadIdoKubun().setSelectedKey(受給者異動情報.get異動区分コード());
        if (RString.isNullOrEmpty(受給者異動情報.get受給者異動事由())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().setSelectedKey(空KEY);
        } else {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().setSelectedKey(受給者異動情報.get受給者異動事由());
        }
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNo().setValue(被保険者番号.value());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNameKana().setValue(受給者異動情報.get被保険者氏名カナ());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtUmareYMD().setValue(受給者異動情報.get生年月日());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getRadSeibetsu().setSelectedKey(受給者異動情報.get性別コード());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuShutokuYMD().setValue(受給者異動情報.get資格取得年月日());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuSoshitsuYMD().setValue(受給者異動情報.get資格喪失年月日());
        if (受給者異動情報.get証記載保険者番号() != null) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShoKisaiHokenshaNo().setValue(受給者異動情報.get証記載保険者番号().value());
        }
        if (受給者異動情報.get広域連合_政令市_保険者番号() != null) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtKoikiHokenshaNo().setValue(受給者異動情報.get広域連合_政令市_保険者番号().value());
        }
        if (受給者異動情報.get送付年月() != null) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtSofuYM().setValue(new FlexibleDate(受給者異動情報.get送付年月().toDateString()));
        }
        if (!(照会モード.equals(処理モード) && INT_1 == 履歴番号)
                && 受給者異動情報.get訂正年月日() != null) {
            div.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD().setValue(new RDate(受給者異動情報.get訂正年月日().toString()));
        }
        if (!照会モード.equals(処理モード) || INT_1 != 履歴番号) {
            div.getJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().setSelectedKey(受給者異動情報.get訂正区分コード());
        }
        set要介護認定エリア(受給者異動情報);
        set支給限度基準額エリア(受給者異動情報);
        set居宅サービス計画エリア(受給者異動情報);
        set住所地特例エリア(受給者異動情報);
        set減免_減額エリア(受給者異動情報);
        set後期高齢_国保エリア(受給者異動情報);
        set給付制限エリア(受給者異動情報);
        set二割負担エリア(受給者異動情報);
        set二次予防事業エリア(受給者異動情報);
        set老人保健エリア(受給者異動情報);
        return 受給者異動情報;
    }

    private void setDivModel(RString 処理モード, FlexibleDate 異動日, int 履歴番号) {
        FlexibleDate 制度改正施行日 = new FlexibleDate(DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_支給限度額一本化,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付).toString());
        if (新規モード.equals(処理モード)) {
            div.setMode_DisplayMode(JukyushaIdoRenrakuhyoDiv.DisplayMode.shinki);
        } else if (訂正モード.equals(処理モード)) {
            div.setMode_DisplayMode(JukyushaIdoRenrakuhyoDiv.DisplayMode.teisei);
        } else if (再発行モード.equals(処理モード)) {
            div.setMode_DisplayMode(JukyushaIdoRenrakuhyoDiv.DisplayMode.saihakko);
            if (INT_1 == 履歴番号) {
                div.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD().setVisible(false);
                div.getJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().setVisible(false);
            }
        } else if (照会モード.equals(処理モード)) {
            div.setMode_DisplayMode(JukyushaIdoRenrakuhyoDiv.DisplayMode.shokai);
        }
        if (新規モード.equals(処理モード) || 訂正モード.equals(処理モード)) {
            if (異動日.isBefore(制度改正施行日)) {
                div.getShikyuGendoKijungakuPanel().getTxtTankiNyushoServiceShikyuGendoKijungaku().setDisabled(true);
                div.getShikyuGendoKijungakuPanel().getTxtTankinyushoServiceJogenKanriTekiyoYMD().setDisabled(true);
            } else {
                div.getShikyuGendoKijungakuPanel().getTxtTankiNyushoServiceShikyuGendoKijungaku().setDisabled(false);
                div.getShikyuGendoKijungakuPanel().getTxtTankinyushoServiceJogenKanriTekiyoYMD().setDisabled(false);
            }
        }
    }

    private void set支給限度基準額エリア項目名称(FlexibleDate 異動日) {
        FlexibleDate 制度改正施行日 = new FlexibleDate(DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_支給限度額一本化,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付).toString());
        if (異動日 != null && 異動日.isBefore(制度改正施行日)) {
            div.getShikyuGendoKijungakuPanel().getLblKyuHomonTsusho().setWidth(WIDTH);
            div.getShikyuGendoKijungakuPanel().getLblKyuTankiNyusho().setWidth(WIDTH);
            div.getShikyuGendoKijungakuPanel().getLblKyuHomonTsusho().setText(居宅サービス_旧訪問通所);
            div.getShikyuGendoKijungakuPanel().getLblKyuTankiNyusho().setText(旧短期入所サービス);
        }
    }

    private void set要介護認定エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        div.getYokaigoNinteiPanel().getTxtShinseiYMD().setValue(受給者異動情報.get申請年月日());
        if (RString.isNullOrEmpty(受給者異動情報.get申請種別コード())) {
            div.getYokaigoNinteiPanel().getRadShinseiShubetsu().setSelectedKey(空KEY);
        } else {
            div.getYokaigoNinteiPanel().getRadShinseiShubetsu().setSelectedKey(受給者異動情報.get申請種別コード());
        }
        if (RString.isNullOrEmpty(受給者異動情報.get要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(空KEY);
        } else {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(受給者異動情報.get要介護状態区分コード());
        }
        if (RString.isNullOrEmpty(受給者異動情報.get変更申請中区分コード())) {
            div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun().setSelectedKey(空KEY);
        } else {
            div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun().setSelectedKey(受給者異動情報.get変更申請中区分コード());
        }
        if (受給者異動情報.get認定有効期間開始年月日() != null) {
            div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().setFromValue(
                    new RDate(受給者異動情報.get認定有効期間開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get認定有効期間終了年月日()) && !RString.isNullOrEmpty(受給者異動情報.get認定有効期間終了年月日())) {
            div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().setToValue(
                    new RDate(受給者異動情報.get認定有効期間終了年月日().toString()));
        }
        if (RString.isNullOrEmpty(受給者異動情報.getみなし要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun().setSelectedKey(空KEY);
        } else {
            div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun().setSelectedKey(受給者異動情報.getみなし要介護状態区分コード());
        }
    }

    private void set支給限度基準額エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        div.getShikyuGendoKijungakuPanel().getTxtHomonTsushoServiceShikyuGendoKijungaku().setValue(
                new Decimal(受給者異動情報.get訪問通所サービス支給限度基準額()));
        if (受給者異動情報.get訪問通所サービス上限管理適用期間開始年月日() != null) {
            div.getShikyuGendoKijungakuPanel().getTxtHomonTsushoServiceJogenKanriTekiyoYMD().setFromValue(
                    new RDate(受給者異動情報.get訪問通所サービス上限管理適用期間開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get訪問通所サービス上限管理適用期間終了年月日())
                && !RString.isNullOrEmpty(受給者異動情報.get訪問通所サービス上限管理適用期間終了年月日())) {
            div.getShikyuGendoKijungakuPanel().getTxtHomonTsushoServiceJogenKanriTekiyoYMD().setToValue(
                    new RDate(受給者異動情報.get訪問通所サービス上限管理適用期間終了年月日().toString()));
        }
        div.getShikyuGendoKijungakuPanel().getTxtTankiNyushoServiceShikyuGendoKijungaku().setValue(
                new Decimal(受給者異動情報.get短期入所サービス支給限度基準額()));
        if (受給者異動情報.get短期入所サービス上限管理適用期間開始年月日() != null) {
            div.getShikyuGendoKijungakuPanel().getTxtTankinyushoServiceJogenKanriTekiyoYMD().setFromValue(
                    new RDate(受給者異動情報.get短期入所サービス上限管理適用期間開始年月日().toString()));
        }
        if (受給者異動情報.get短期入所サービス上限管理適用期間終了年月日() != null) {
            div.getShikyuGendoKijungakuPanel().getTxtTankinyushoServiceJogenKanriTekiyoYMD().setToValue(
                    new RDate(受給者異動情報.get短期入所サービス上限管理適用期間終了年月日().toString()));
        }
    }

    private void set居宅サービス計画エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        //QA1190
        if (!星.equals(受給者異動情報.get居宅サービス計画作成区分コード())) {
            if (RString.isNullOrEmpty(受給者異動情報.get居宅サービス計画作成区分コード())) {
                div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().setSelectedKey(空KEY);
            } else {
                div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().setSelectedKey(
                        受給者異動情報.get居宅サービス計画作成区分コード());
            }
        }
        if (!星.equals(受給者異動情報.get居宅介護支援事業所番号())) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().setValue(
                    受給者異動情報.get居宅介護支援事業所番号());
            FlexibleDate 異動日Para;
            if (受給者異動情報.get異動年月日() != null) {
                異動日Para = 受給者異動情報.get異動年月日();
            } else {
                異動日Para = new FlexibleDate(RDate.getNowDate().toString());
            }
            AtenaMeisho 支援事業者名称 = JukyushaTeiseiRenrakuhyoToroku.createInstance().getSienJikyoshaName(
                    new JigyoshaNo(受給者異動情報.get居宅介護支援事業所番号()), 受給者異動情報.get居宅サービス計画作成区分コード(), 異動日Para);

            if (支援事業者名称 != null) {
                div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoName().setValue(支援事業者名称.value());
            }
        }
        if (!星.equals(受給者異動情報.get居宅サービス計画適用開始年月日())
                && !RString.isNullOrEmpty(受給者異動情報.get居宅サービス計画適用開始年月日())) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().setFromValue(
                    new RDate(受給者異動情報.get居宅サービス計画適用開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get居宅サービス計画適用終了年月日())
                && !RString.isNullOrEmpty(受給者異動情報.get居宅サービス計画適用終了年月日())) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().setToValue(
                    new RDate(受給者異動情報.get居宅サービス計画適用終了年月日().toString()));
        }
        if (受給者異動情報.is小多機能居宅介護利用開始月利用有フラグ()) {
            div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().
                    setSelectedKey(JukyushaIF_ShokiboKyotakuServiceRIyoCode.利用有り.getコード());
        } else {
            div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().setSelectedKey(
                    JukyushaIF_ShokiboKyotakuServiceRIyoCode.利用無し.getコード());
        }
    }

    private void set住所地特例エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        if (!星.equals(受給者異動情報.get住所地特例対象者区分コード())) {
            if (RString.isNullOrEmpty(受給者異動情報.get住所地特例対象者区分コード())) {
                div.getJushochiTokureiPanel().getRadJushochiTokureiTaishoshaKubun().setSelectedKey(空KEY);
            } else {
                div.getJushochiTokureiPanel().getRadJushochiTokureiTaishoshaKubun().setSelectedKey(受給者異動情報.get住所地特例対象者区分コード());
            }
        }
        if (!星.equals(受給者異動情報.get住所地特例適用開始日()) && !RString.isNullOrEmpty(受給者異動情報.get住所地特例適用開始日())) {
            div.getJushochiTokureiPanel().getTxtJushochiTokureiTekiyoYMD().setFromValue(
                    new RDate(受給者異動情報.get住所地特例適用開始日().toString()));
        }
        if (!星.equals(受給者異動情報.get住所地特例適用終了日()) && !RString.isNullOrEmpty(受給者異動情報.get住所地特例適用終了日())) {
            div.getJushochiTokureiPanel().getTxtJushochiTokureiTekiyoYMD().setToValue(
                    new RDate(受給者異動情報.get住所地特例適用終了日().toString()));
        }
        div.getJushochiTokureiPanel().getHokenshaJohoPanel().getTxtShisetsuShozaiHokenjaNo().setValue(受給者異動情報.get施設所在保険者番号());
    }

    private void set減免_減額エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        if (RString.isNullOrEmpty(受給者異動情報.get減免申請中区分コード())) {
            div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun().setSelectedKey(空KEY);
        } else {
            div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun().setSelectedKey(受給者異動情報.get減免申請中区分コード());
        }
        if (!星.equals(受給者異動情報.get利用者負担区分コード())) {
            if (RString.isNullOrEmpty(受給者異動情報.get利用者負担区分コード())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                        getJukyushaIdoRenrakuhyoRiyoshaFutan().getRadRiyoshaFutanKubunCode().setSelectedKey(空KEY);
            } else {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                        getJukyushaIdoRenrakuhyoRiyoshaFutan().getRadRiyoshaFutanKubunCode().setSelectedKey(受給者異動情報.get利用者負担区分コード());
            }
        }
        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtKyufuritsu().setValue(受給者異動情報.get給付率());
        if (!星.equals(受給者異動情報.get適用開始年月日()) && !RString.isNullOrEmpty(受給者異動情報.get適用開始年月日())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoRiyoshaFutan().
                    getTxtTekiyoYMD().setFromValue(new RDate(受給者異動情報.get適用開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get適用終了年月日()) && !RString.isNullOrEmpty(受給者異動情報.get適用終了年月日())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoRiyoshaFutan().
                    getTxtTekiyoYMD().setToValue(new RDate(受給者異動情報.get適用終了年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get軽減率()) && !RString.isNullOrEmpty(受給者異動情報.get軽減率())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen().
                    getTxtKeigenritsu().setValue(new Decimal(受給者異動情報.get軽減率().toString()));
        }
        if (!星.equals(受給者異動情報.get軽減率適用開始年月日()) && !RString.isNullOrEmpty(受給者異動情報.get軽減率適用開始年月日())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen().
                    getTxtKeigenritsuTekiyoYMD().setFromValue(new RDate(受給者異動情報.get軽減率適用開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get軽減率適用終了年月日()) && !RString.isNullOrEmpty(受給者異動情報.get軽減率適用終了年月日())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen().
                    getTxtKeigenritsuTekiyoYMD().setToValue(new RDate(受給者異動情報.get軽減率適用終了年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get標準負担区分コード())) {
            if (RString.isNullOrEmpty(受給者異動情報.get標準負担区分コード())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                        getRadHyojunFutanKubun().setSelectedKey(空KEY);
            } else {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                        getRadHyojunFutanKubun().setSelectedKey(受給者異動情報.get標準負担区分コード());
            }
        }
        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                getTxtFutangaku().setValue(受給者異動情報.get負担額());
        if (!星.equals(受給者異動情報.get負担額適用開始年月日()) && !RString.isNullOrEmpty(受給者異動情報.get負担額適用開始年月日())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                    getTxtFutangakuTekiyoYMD().setFromValue(new RDate(受給者異動情報.get負担額適用開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get負担額適用終了年月日()) && !RString.isNullOrEmpty(受給者異動情報.get負担額適用終了年月日())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                    getTxtFutangakuTekiyoYMD().setToValue(new RDate(受給者異動情報.get負担額適用終了年月日().toString()));
        }
        if (RString.isNullOrEmpty(受給者異動情報.get特定入所者認定申請中区分コード())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getRadTokuteiNyushoshaNinteiShinseichuKubun().setSelectedKey(空KEY);
        } else {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getRadTokuteiNyushoshaNinteiShinseichuKubun().setSelectedKey(受給者異動情報.get特定入所者認定申請中区分コード());
        }
        if (!星.equals(受給者異動情報.get特定入所者介護サービス区分コード())) {
            if (RString.isNullOrEmpty(受給者異動情報.get特定入所者介護サービス区分コード())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadTokuteiNyushoshaKaigoServiceKubun().setSelectedKey(空KEY);
            } else {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadTokuteiNyushoshaKaigoServiceKubun().setSelectedKey(受給者異動情報.get特定入所者介護サービス区分コード());
            }
        }
        if (!星.equals(受給者異動情報.is課税層の特例減額措置対象フラグ())) {
            if (RString.isNullOrEmpty(受給者異動情報.is課税層の特例減額措置対象フラグ())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadKaizeisoTokureiGengakuSochiTaishoFlag().setSelectedKey(空KEY);
            } else {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadKaizeisoTokureiGengakuSochiTaishoFlag().setSelectedKey(受給者異動情報.is課税層の特例減額措置対象フラグ());
            }
        }
        if (!星.equals(受給者異動情報.get食費負担限度額()) && !RString.isNullOrEmpty(受給者異動情報.get食費負担限度額())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtShokuhiFutanGendogaku().setValue(new Decimal(受給者異動情報.get食費負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get負担限度額適用開始年月日())
                && !RString.isNullOrEmpty(受給者異動情報.get負担限度額適用開始年月日())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtFutanGendogakuTekiyoYMD().setFromValue(new RDate(受給者異動情報.get負担限度額適用開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get負担限度額適用終了年月日())
                && !RString.isNullOrEmpty(受給者異動情報.get負担限度額適用終了年月日())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtFutanGendogakuTekiyoYMD().setToValue(new RDate(受給者異動情報.get負担限度額適用終了年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get居住費従来型個室特養等負担限度額())
                && !RString.isNullOrEmpty(受給者異動情報.get居住費従来型個室特養等負担限度額())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtJuraigataKoshitsuTokuyoFutanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居住費従来型個室特養等負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居住費従来型個室老健療養等負担限度額())
                && !RString.isNullOrEmpty(受給者異動情報.get居住費従来型個室老健療養等負担限度額())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居住費従来型個室老健療養等負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居住費多床室負担限度額()) && !RString.isNullOrEmpty(受給者異動情報.get居住費多床室負担限度額())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtTashoshitsu().
                    setValue(new Decimal(受給者異動情報.get居住費多床室負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居住費ユニット型個室負担限度額())
                && !RString.isNullOrEmpty(受給者異動情報.get居住費ユニット型個室負担限度額())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtUnitKoshitsuGendogaku().
                    setValue(new Decimal(受給者異動情報.get居住費ユニット型個室負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居住費ユニット型準個室負担限度額())
                && !RString.isNullOrEmpty(受給者異動情報.get居住費ユニット型準個室負担限度額())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtUnitJunKoshitsuFutanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居住費ユニット型準個室負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居宅費_新１_負担限度額()) && !RString.isNullOrEmpty(受給者異動情報.get居宅費_新１_負担限度額())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin1FutanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居宅費_新１_負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居宅費_新２_負担限度額()) && !RString.isNullOrEmpty(受給者異動情報.get居宅費_新２_負担限度額())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin2FutanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居宅費_新２_負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居宅費_新３_負担限度額()) && !RString.isNullOrEmpty(受給者異動情報.get居宅費_新３_負担限度額())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin3utanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居宅費_新３_負担限度額().toString()));
        }
    }

    private void set後期高齢_国保エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        if (!星.equals(受給者異動情報.get後期高齢者医療保険者番号())) {
            div.getKokiKoureiIryoHokenshaPanel().getKokiKoureiPanel().
                    getTxtKokiKoureiIryoHokenshaNo().setValue(受給者異動情報.get後期高齢者医療保険者番号());
        }
        if (!星.equals(受給者異動情報.get後期高齢者医療被保険者番号())) {
            div.getKokiKoureiIryoHokenshaPanel().getKokiKoureiPanel().
                    getTxtKokikoureiIryoHiHokenshaNo().setValue(受給者異動情報.get後期高齢者医療被保険者番号());
        }
        if (!星.equals(受給者異動情報.get国民健康保険保険者番号())) {
            div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().
                    getTxtKokuhoHokenshaNo().setValue(受給者異動情報.get国民健康保険保険者番号());
        }
        if (!星.equals(受給者異動情報.get国民健康保険被保険者証番号())) {
            div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().
                    getTxtKokuhoHiHokenshaNo().setValue(受給者異動情報.get国民健康保険被保険者証番号());
        }
        if (!星.equals(受給者異動情報.get国民健康保険個人番号())) {
            div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().
                    getTxtKokuhoKojinNo().setValue(受給者異動情報.get国民健康保険個人番号());
        }
    }

    private void set給付制限エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        if (受給者異動情報.is公費負担上限額減額有フラグ()) {
            div.getKyufuSeigenPanel().getRadKohiFutanJogenGengakuAriFlag().setSelectedKey(
                    JukyushaIF_kohiFutanJogengakuGengakuUmu.有り.getコード());
        } else {
            div.getKyufuSeigenPanel().getRadKohiFutanJogenGengakuAriFlag().setSelectedKey(
                    JukyushaIF_kohiFutanJogengakuGengakuUmu.無し.getコード());
        }
        if (!星.equals(受給者異動情報.get償還払化開始年月日()) && !RString.isNullOrEmpty(受給者異動情報.get償還払化開始年月日())) {
            div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD().setFromValue(new RDate(受給者異動情報.get償還払化開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get償還払化終了年月日()) && !RString.isNullOrEmpty(受給者異動情報.get償還払化終了年月日())) {
            div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD().setToValue(new RDate(受給者異動情報.get償還払化終了年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get給付率引下げ開始年月日()) && !RString.isNullOrEmpty(受給者異動情報.get給付率引下げ開始年月日())) {
            div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage().setFromValue(new RDate(受給者異動情報.get給付率引下げ開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get給付率引下げ終了年月日()) && !RString.isNullOrEmpty(受給者異動情報.get給付率引下げ終了年月日())) {
            div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage().setToValue(new RDate(受給者異動情報.get給付率引下げ終了年月日().toString()));
        }
    }

    private void set二割負担エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        if (!星.equals(受給者異動情報.get利用者負担割合有効開始日()) && !RString.isNullOrEmpty(受給者異動情報.get利用者負担割合有効開始日())) {
            div.getRiyosyaFutanWariaiPanel().getTxtRiyosyaFutanWariaiYukoYMD().setFromValue(
                    new RDate(受給者異動情報.get利用者負担割合有効開始日().toString()));
        }
        if (!星.equals(受給者異動情報.get利用者負担割合有効終了日()) && !RString.isNullOrEmpty(受給者異動情報.get利用者負担割合有効終了日())) {
            div.getRiyosyaFutanWariaiPanel().getTxtRiyosyaFutanWariaiYukoYMD().setToValue(
                    new RDate(受給者異動情報.get利用者負担割合有効終了日().toString()));
        }
    }

    private void set二次予防事業エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        if (RString.isNullOrEmpty(受給者異動情報.get二次予防事業区分コード())) {
            div.getNijiyoboJigyoPanel().getRadNijiyoboJigyoKubun().setSelectedKey(空KEY);
        } else {
            div.getNijiyoboJigyoPanel().getRadNijiyoboJigyoKubun().setSelectedKey(受給者異動情報.get二次予防事業区分コード());
        }
        if (受給者異動情報.get二次予防事業有効期間開始年月日() != null) {
            div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange().setFromValue(
                    new RDate(受給者異動情報.get二次予防事業有効期間開始年月日().toString()));
        }
        if (受給者異動情報.get二次予防事業有効期間終了年月日() != null) {
            div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange().setToValue(
                    new RDate(受給者異動情報.get二次予防事業有効期間終了年月日().toString()));
        }
        onClick_事業区分();

    }

    private void set老人保健エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        div.getRojinHokenPanel().getTxtRojinHokenShichosonNo().setValue(受給者異動情報.get老人保健市町村番号());
        div.getRojinHokenPanel().getTxtRojinHokenJukyushaNo().setValue(受給者異動情報.get老人保健受給者番号());
        div.getRojinHokenPanel().getTxtKohiFutanshaNo().setValue(受給者異動情報.get公費負担者番号());
    }

    /**
     * 「事業区分」操作制御のメソッドです。
     *
     */
    public void onClick_事業区分() {
        RString 事業区分Key = div.getNijiyoboJigyoPanel().getRadNijiyoboJigyoKubun().getSelectedKey();
        if (JukyushaIF_NijiyoboJigyoKubunCode.該当.getコード().equals(事業区分Key)) {
            div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange().setDisabled(false);
        } else {
            div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange().setDisabled(true);
        }
    }

    /**
     * 「計画作成区分」操作制御のメソッドです。
     *
     */
    public void onClick_計画作成区分() {
        RString 計画作成区分Key = div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().getSelectedKey();
        if (空KEY.equals(計画作成区分Key)) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().setReadOnly(true);
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoName().setReadOnly(true);
            div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().setReadOnly(true);
            div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().setReadOnly(true);
        } else if (JukyushaIF_KeikakuSakuseiKubunCode.自己作成.getコード().equals(計画作成区分Key)) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().setReadOnly(true);
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoName().setReadOnly(true);
            div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().setReadOnly(false);
            div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().setReadOnly(false);
        } else if (JukyushaIF_KeikakuSakuseiKubunCode.居宅介護支援事業所作成.getコード().equals(計画作成区分Key)
                || JukyushaIF_KeikakuSakuseiKubunCode.介護予防支援事業所_地域包括支援センター作成.getコード().equals(計画作成区分Key)) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().setReadOnly(false);
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoName().setReadOnly(false);
            div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().setReadOnly(false);
            div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().setReadOnly(false);
        }
    }

    /**
     * 異動日focus outのメソッドです。
     *
     */
    public void onBlur_異動日() {
        RString 保険者番号 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNo().getValue();
        FlexibleDate 異動日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue();
        if (異動日 != null && !異動日.toString().isEmpty()) {
            List<ShoKisaiHokenshaNo> 証記載保険者番号と広域保険者番号
                    = JukyushaTeiseiRenrakuhyoToroku.createInstance().getShokisaiNotoKouikiNo(new HihokenshaNo(保険者番号), 異動日);
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShoKisaiHokenshaNo().setValue(証記載保険者番号と広域保険者番号.get(0).value());
        }
    }

    /**
     * 支援事業者番号focus outのメソッドです。
     *
     */
    public void onBlur_支援事業者番号() {
        RString 計画作成区分Key = div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().getSelectedKey();
        RString 支援事業者番号 = div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().getValue();
        if (RString.isNullOrEmpty(支援事業者番号)) {
            return;
        }
        RString 計画作成区分;
        if (JukyushaIF_KeikakuSakuseiKubunCode.居宅介護支援事業所作成.getコード().equals(計画作成区分Key)) {
            計画作成区分 = JukyushaIF_KeikakuSakuseiKubunCode.居宅介護支援事業所作成.getコード();
        } else {
            計画作成区分 = JukyushaIF_KeikakuSakuseiKubunCode.介護予防支援事業所_地域包括支援センター作成.getコード();
        }
        FlexibleDate 異動日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue();
        if (異動日 == null) {
            異動日 = new FlexibleDate(RDate.getNowDate().toString());
        }
        AtenaMeisho 支援事業者名称
                = JukyushaTeiseiRenrakuhyoToroku.createInstance().getSienJikyoshaName(new JigyoshaNo(支援事業者番号), 計画作成区分, 異動日);
        if (支援事業者名称 != null) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoName().setValue(支援事業者名称.value());
        }

    }

    /**
     * 住所地特例の保険者番号focus outのメソッドです。
     *
     */
    public void onBlur_保険者番号() {
        RString 保険者番号 = div.getJushochiTokureiPanel().getHokenshaJohoPanel().
                getTxtShisetsuShozaiHokenjaNo().getValue();
        if (!RString.isNullOrEmpty(保険者番号)) {
            HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
            Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(保険者番号));
            if (hokensha != null) {
                div.getJushochiTokureiPanel().getHokenshaJohoPanel().
                        getTxtHokenshaMeisho().setValue(hokensha.get保険者名());
            }
        }
    }

    /**
     * 受給者異動送付取得のメソッドです。
     *
     * @param 履歴番号 int
     * @return JukyushaIdoRenrakuhyo
     */
    public JukyushaIdoRenrakuhyo get受給者異動送付(int 履歴番号) {
        FlexibleDate 異動年月日 = div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue();
        RString 異動区分コード = div.getJukyushaIdoRenrakuhyoKihonJoho().getRadIdoKubun().getSelectedKey();
        RString 受給者異動事由 = div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().getSelectedKey();
        ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(
                div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShoKisaiHokenshaNo().getValue());
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNo().getValue());
        JukyushaIdoRenrakuhyo 受給者異動送付 = new JukyushaIdoRenrakuhyo(
                異動年月日, 異動区分コード, 受給者異動事由, 証記載保険者番号, 被保険者番号, 履歴番号);
        JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder = 受給者異動送付.createBuilderForEdit();
        受給者異動送付Builder.set証記載保険者番号(証記載保険者番号);
        set受給者異動送付Builder(受給者異動送付Builder);
        return 受給者異動送付Builder.build();
    }

    private void set受給者異動送付Builder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        受給者異動送付Builder.set被保険者氏名カナ(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNameKana().getValue());
        受給者異動送付Builder.set生年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtUmareYMD().getValue());
        受給者異動送付Builder.set性別コード(div.getJukyushaIdoRenrakuhyoKihonJoho().getRadSeibetsu().getSelectedKey());
        受給者異動送付Builder.set資格取得年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuShutokuYMD().getValue());
        受給者異動送付Builder.set資格喪失年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuSoshitsuYMD().getValue());
        受給者異動送付Builder.set広域連合_政令市_保険者番号(
                new ShoKisaiHokenshaNo(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtKoikiHokenshaNo().getValue()));
        受給者異動送付Builder.set送付年月(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtSofuYM().getValue().getYearMonth());
        受給者異動送付Builder.set訂正年月日(new FlexibleDate(
                div.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD().getValue().toString()));
        受給者異動送付Builder.set訂正区分コード(div.getJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().getSelectedKey());
        set要介護認定エリアBuilder(受給者異動送付Builder);
        set支給限度基準額エリアBuilder(受給者異動送付Builder);
        set居宅サービス計画エリアBuilder(受給者異動送付Builder);
        set住所地特例エリアBuilder(受給者異動送付Builder);
        set減免_減額エリアBuilder(受給者異動送付Builder);
        set後期高齢_国保エリアBuilder(受給者異動送付Builder);
        set給付制限エリアBuilder(受給者異動送付Builder);
        set二割負担エリアBuilder(受給者異動送付Builder);
        set二次予防事業エリアBuilder(受給者異動送付Builder);
        set老人保健エリアBuilder(受給者異動送付Builder);
    }

    private void set要介護認定エリアBuilder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        受給者異動送付Builder.set申請年月日(div.getYokaigoNinteiPanel().getTxtShinseiYMD().getValue());
        受給者異動送付Builder.set申請種別コード(div.getYokaigoNinteiPanel().getRadShinseiShubetsu().getSelectedKey());
        受給者異動送付Builder.set要介護状態区分コード(div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().getSelectedKey());
        受給者異動送付Builder.set変更申請中区分コード(div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun().getSelectedKey());
        受給者異動送付Builder.set認定有効期間開始年月日(
                new FlexibleDate(div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().getFromValue().toString()));
        受給者異動送付Builder.set認定有効期間終了年月日(
                new RString(div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().getFromValue().toString()));
        受給者異動送付Builder.setみなし要介護状態区分コード(div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun().getSelectedKey());
    }

    private void set支給限度基準額エリアBuilder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        受給者異動送付Builder.set訪問通所サービス支給限度基準額(div.getShikyuGendoKijungakuPanel().
                getTxtHomonTsushoServiceShikyuGendoKijungaku().getValue().intValue());
        受給者異動送付Builder.set訪問通所サービス上限管理適用期間開始年月日(new FlexibleDate(
                div.getShikyuGendoKijungakuPanel().getTxtHomonTsushoServiceJogenKanriTekiyoYMD().getFromValue().toString()));
        受給者異動送付Builder.set訪問通所サービス上限管理適用期間終了年月日(new RString(
                div.getShikyuGendoKijungakuPanel().getTxtHomonTsushoServiceJogenKanriTekiyoYMD().getFromValue().toString()));
        受給者異動送付Builder.set短期入所サービス支給限度基準額(
                div.getShikyuGendoKijungakuPanel().getTxtTankiNyushoServiceShikyuGendoKijungaku().getValue().intValue());
        受給者異動送付Builder.set短期入所サービス上限管理適用期間開始年月日(new FlexibleDate(
                div.getShikyuGendoKijungakuPanel().getTxtTankinyushoServiceJogenKanriTekiyoYMD().getFromValue().toString()));
        受給者異動送付Builder.set短期入所サービス上限管理適用期間終了年月日(new FlexibleDate(
                div.getShikyuGendoKijungakuPanel().getTxtTankinyushoServiceJogenKanriTekiyoYMD().getFromValue().toString()));
    }

    private void set居宅サービス計画エリアBuilder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        受給者異動送付Builder.set居宅サービス計画作成区分コード(div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().getSelectedKey());
        受給者異動送付Builder.set居宅介護支援事業所番号(div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().getValue());
        受給者異動送付Builder.set居宅サービス計画適用開始年月日(
                new RString(div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().getFromValue().toString()));
        受給者異動送付Builder.set居宅サービス計画適用終了年月日(
                new RString(div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().getToValue().toString()));
        if (JukyushaIF_ShokiboKyotakuServiceRIyoCode.利用有り.getコード().
                equals(div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().getSelectedKey())) {
            受給者異動送付Builder.set小多機能居宅介護利用開始月利用有フラグ(true);
        } else {
            受給者異動送付Builder.set小多機能居宅介護利用開始月利用有フラグ(false);
        }
    }

    private void set住所地特例エリアBuilder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        受給者異動送付Builder.set住所地特例対象者区分コード(div.getJushochiTokureiPanel().getRadJushochiTokureiTaishoshaKubun().getSelectedKey());
        受給者異動送付Builder.set住所地特例適用開始日(
                new RString(div.getJushochiTokureiPanel().getTxtJushochiTokureiTekiyoYMD().getFromValue().toString()));
        受給者異動送付Builder.set住所地特例適用終了日(
                new RString(div.getJushochiTokureiPanel().getTxtJushochiTokureiTekiyoYMD().getToValue().toString()));
        受給者異動送付Builder.set施設所在保険者番号(
                div.getJushochiTokureiPanel().getHokenshaJohoPanel().getTxtShisetsuShozaiHokenjaNo().getValue());
    }

    private void set減免_減額エリアBuilder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        受給者異動送付Builder.set減免申請中区分コード(div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun().getSelectedKey());
        受給者異動送付Builder.set利用者負担区分コード(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getRadRiyoshaFutanKubunCode().getSelectedKey());
        受給者異動送付Builder.set給付率(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtKyufuritsu().getValue());
        受給者異動送付Builder.set適用開始年月日(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtTekiyoYMD().getFromValue().toString()));
        受給者異動送付Builder.set適用終了年月日(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtTekiyoYMD().getToValue().toString()));
        受給者異動送付Builder.set軽減率(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen().
                getTxtKeigenritsu().getValue().toString()));
        受給者異動送付Builder.set軽減率適用開始年月日(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen().
                getTxtKeigenritsuTekiyoYMD().getFromValue().toString()));
        受給者異動送付Builder.set軽減率適用終了年月日(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen().
                getTxtKeigenritsuTekiyoYMD().getToValue().toString()));
        受給者異動送付Builder.set標準負担区分コード(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                getRadHyojunFutanKubun().getSelectedKey());
        受給者異動送付Builder.set負担額(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangaku().getValue());
        受給者異動送付Builder.set負担額適用開始年月日(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                getTxtFutangakuTekiyoYMD().getFromValue().toString()));
        受給者異動送付Builder.set負担額適用終了年月日(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                getTxtFutangakuTekiyoYMD().getToValue().toString()));
        受給者異動送付Builder.set特定入所者認定申請中区分コード(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getRadTokuteiNyushoshaNinteiShinseichuKubun().getSelectedKey());
        受給者異動送付Builder.set特定入所者介護サービス区分コード(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getRadTokuteiNyushoshaKaigoServiceKubun().getSelectedKey());
        受給者異動送付Builder.set課税層の特例減額措置対象フラグ(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getRadKaizeisoTokureiGengakuSochiTaishoFlag().getSelectedKey());
        受給者異動送付Builder.set食費負担限度額(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtShokuhiFutanGendogaku().getValue().toString()));
        受給者異動送付Builder.set負担限度額適用開始年月日(new RString(
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtFutanGendogakuTekiyoYMD().getFromValue().toString()));
        受給者異動送付Builder.set負担限度額適用終了年月日(new RString(
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtFutanGendogakuTekiyoYMD().getToValue().toString()));
        受給者異動送付Builder.set居住費従来型個室特養等負担限度額(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtJuraigataKoshitsuTokuyoFutanGendogaku().getValue().toString()));
        受給者異動送付Builder.set居住費従来型個室老健療養等負担限度額(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku().getValue().toString()));
        受給者異動送付Builder.set居住費多床室負担限度額(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtTashoshitsu().
                getValue().toString()));
        受給者異動送付Builder.set居住費ユニット型個室負担限度額(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtUnitKoshitsuGendogaku().
                getValue().toString()));
        受給者異動送付Builder.set居住費ユニット型準個室負担限度額(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtUnitJunKoshitsuFutanGendogaku().
                getValue().toString()));
        受給者異動送付Builder.set居宅費_新１_負担限度額(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin1FutanGendogaku().
                getValue().toString()));
        受給者異動送付Builder.set居宅費_新２_負担限度額(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin2FutanGendogaku().
                getValue().toString()));
        受給者異動送付Builder.set居宅費_新３_負担限度額(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin3utanGendogaku().
                getValue().toString()));
    }

    private void set後期高齢_国保エリアBuilder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        受給者異動送付Builder.set後期高齢者医療保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokiKoureiPanel().
                getTxtKokiKoureiIryoHokenshaNo().getValue());
        受給者異動送付Builder.set後期高齢者医療被保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokiKoureiPanel().
                getTxtKokikoureiIryoHiHokenshaNo().getValue());
        受給者異動送付Builder.set国民健康保険保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().
                getTxtKokuhoHokenshaNo().getValue());
        受給者異動送付Builder.set国民健康保険被保険者証番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().
                getTxtKokuhoHiHokenshaNo().getValue());
        受給者異動送付Builder.set国民健康保険個人番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().
                getTxtKokuhoKojinNo().getValue());
    }

    private void set給付制限エリアBuilder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        if (JukyushaIF_kohiFutanJogengakuGengakuUmu.有り.getコード().
                equals(div.getKyufuSeigenPanel().getRadKohiFutanJogenGengakuAriFlag().getSelectedKey())) {
            受給者異動送付Builder.set公費負担上限額減額有フラグ(true);
        } else {
            受給者異動送付Builder.set公費負担上限額減額有フラグ(false);
        }
        受給者異動送付Builder.set償還払化開始年月日(new RString(
                div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD().getFromValue().toString()));
        受給者異動送付Builder.set償還払化終了年月日(new RString(
                div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD().getToValue().toString()));
        受給者異動送付Builder.set給付率引下げ開始年月日(new RString(
                div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage().getFromValue().toString()));
        受給者異動送付Builder.set給付率引下げ終了年月日(new RString(
                div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage().getToValue().toString()));
    }

    private void set二割負担エリアBuilder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        受給者異動送付Builder.set利用者負担割合有効開始日(new RString(
                div.getRiyosyaFutanWariaiPanel().getTxtRiyosyaFutanWariaiYukoYMD().getFromValue().toString()));
        受給者異動送付Builder.set利用者負担割合有効終了日(new RString(
                div.getRiyosyaFutanWariaiPanel().getTxtRiyosyaFutanWariaiYukoYMD().getToValue().toString()));
    }

    private void set二次予防事業エリアBuilder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        受給者異動送付Builder.set二次予防事業区分コード(div.getNijiyoboJigyoPanel().getRadNijiyoboJigyoKubun().getSelectedKey());
        受給者異動送付Builder.set二次予防事業有効期間開始年月日(new FlexibleDate(
                div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange().getFromValue().toString()));
        受給者異動送付Builder.set二次予防事業有効期間終了年月日(new FlexibleDate(
                div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange().getToValue().toString()));
    }

    private void set老人保健エリアBuilder(JukyushaIdoRenrakuhyoBuilder 受給者異動送付Builder) {
        受給者異動送付Builder.set老人保健市町村番号(div.getRojinHokenPanel().getTxtRojinHokenShichosonNo().getValue());
        受給者異動送付Builder.set老人保健受給者番号(div.getRojinHokenPanel().getTxtRojinHokenJukyushaNo().getValue());
        受給者異動送付Builder.set公費負担者番号(div.getRojinHokenPanel().getTxtKohiFutanshaNo().getValue());
    }

    /**
     * 異動事由DropDownListを作成します。
     *
     * @return List<KeyValueDataSource>
     */
    private List<KeyValueDataSource> create異動事由DropDownList() {
        List<KeyValueDataSource> keiyakuServiceShuruiList = new ArrayList<>();
        keiyakuServiceShuruiList.add(new KeyValueDataSource(空KEY, RString.EMPTY));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                JukyushaIF_JukyushaIdoJiyu.受給資格取得.getコード(), JukyushaIF_JukyushaIdoJiyu.受給資格取得.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                JukyushaIF_JukyushaIdoJiyu.受給資格喪失.getコード(), JukyushaIF_JukyushaIdoJiyu.受給資格喪失.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                JukyushaIF_JukyushaIdoJiyu.広域連合における受給者の市町村間転居異動.getコード(),
                JukyushaIF_JukyushaIdoJiyu.広域連合における受給者の市町村間転居異動.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                JukyushaIF_JukyushaIdoJiyu.合併による新規.getコード(), JukyushaIF_JukyushaIdoJiyu.合併による新規.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                JukyushaIF_JukyushaIdoJiyu.その他異動.getコード(), JukyushaIF_JukyushaIdoJiyu.その他異動.get名称()));
        return keiyakuServiceShuruiList;
    }

    /**
     * 状態区分DropDownListを作成します。
     *
     * @return List<KeyValueDataSource>
     */
    private List<KeyValueDataSource> create状態区分DropDownList() {
        List<KeyValueDataSource> keiyakuServiceShuruiList = new ArrayList<>();
        keiyakuServiceShuruiList.add(new KeyValueDataSource(空KEY, RString.EMPTY));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                YokaigoJotaiKubun99.非該当.getコード(), YokaigoJotaiKubun99.非該当.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                YokaigoJotaiKubun.事業対象外.getコード(), YokaigoJotaiKubun.事業対象外.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                YokaigoJotaiKubun99.経過的要介護.getコード(), YokaigoJotaiKubun99.経過的要介護.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                YokaigoJotaiKubun06.要支援1.getコード(), YokaigoJotaiKubun06.要支援1.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                YokaigoJotaiKubun06.要支援2.getコード(), YokaigoJotaiKubun06.要支援2.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                YokaigoJotaiKubun99.要介護1.getコード(), YokaigoJotaiKubun99.要介護1.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                YokaigoJotaiKubun99.要介護2.getコード(), YokaigoJotaiKubun99.要介護2.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                YokaigoJotaiKubun99.要介護3.getコード(), YokaigoJotaiKubun99.要介護3.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                YokaigoJotaiKubun99.要介護4.getコード(), YokaigoJotaiKubun99.要介護4.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                YokaigoJotaiKubun99.要介護5.getコード(), YokaigoJotaiKubun99.要介護5.get名称()));
        return keiyakuServiceShuruiList;
    }

    /**
     * 出力用受給者訂正情報Entityをを取得のメソッドです。
     *
     * @return JukyushaIdoRenrakuhyoTorokuEntity
     */
    public JukyushaIdoRenrakuhyoTorokuEntity get受給者訂正連絡票Entity() {
        JukyushaIdoRenrakuhyoTorokuEntity entity = new JukyushaIdoRenrakuhyoTorokuEntity();
        entity.set証記載保険者番号(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShoKisaiHokenshaNo().getValue());
        entity.set被保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().
                getTxtKokuhoHiHokenshaNo().getValue());
        entity.set異動年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue());
        entity.set異動区分(div.getJukyushaIdoRenrakuhyoKihonJoho().getRadIdoKubun().getSelectedKey());
        entity.set性別(div.getJukyushaIdoRenrakuhyoKihonJoho().getRadSeibetsu().getSelectedKey());
        entity.set異動事由(div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().getSelectedKey());
        entity.set被保険者氏名カナ(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNameKana().getValue());
        entity.set生年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtUmareYMD().getValue());
        entity.set資格取得年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuShutokuYMD().getValue());
        entity.set資格喪失年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuSoshitsuYMD().getValue());
        entity.setみなし区分(div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun().getSelectedKey());
        entity.set要介護状態区分(div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().getSelectedKey());
        entity.set有効期間開始年月日(new FlexibleDate(div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().
                getFromValue().toDateString()));
        entity.set有効期間終了年月日(new FlexibleDate(div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().
                getToValue().toDateString()));
        entity.set支給限度基準額1(new RString(div.getShikyuGendoKijungakuPanel().
                getTxtHomonTsushoServiceShikyuGendoKijungaku().getValue().toString()));
        entity.set上限管理適用開始年月日１(new FlexibleDate(div.getShikyuGendoKijungakuPanel().
                getTxtHomonTsushoServiceJogenKanriTekiyoYMD().getFromValue().toDateString()));
        entity.set上限管理終了年月日１(new FlexibleDate(div.getShikyuGendoKijungakuPanel().
                getTxtHomonTsushoServiceJogenKanriTekiyoYMD().getToValue().toDateString()));
        entity.set支給限度基準額２(new RString(div.getShikyuGendoKijungakuPanel().
                getTxtTankiNyushoServiceShikyuGendoKijungaku().getValue().toString()));
        entity.set上限管理適用開始年月日２(new FlexibleDate(div.getShikyuGendoKijungakuPanel().
                getTxtTankinyushoServiceJogenKanriTekiyoYMD().getFromValue().toDateString()));
        entity.set上限管理終了年月日２(new FlexibleDate(div.getShikyuGendoKijungakuPanel().
                getTxtTankinyushoServiceJogenKanriTekiyoYMD().getToValue().toDateString()));
        entity.set計画作成区分(div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().getSelectedKey());
        entity.set居宅支援事業者番号(div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().getValue());
        entity.set居宅適用開始年月日(new FlexibleDate(div.getKyotakuServicePlanPanel().
                getTxtKyotakuServiceTekiyoYMD().getFromValue().toDateString()));
        entity.set居宅適用終了年月日(new FlexibleDate(div.getKyotakuServicePlanPanel().
                getTxtKyotakuServiceTekiyoYMD().getToValue().toDateString()));
        entity.set減免申請中区分(div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun().getSelectedKey());
        entity.set利用者負担区分(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getRadRiyoshaFutanKubunCode().getSelectedKey());
        entity.set利用給付率(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().
                getTxtKyufuritsu().getValue().toString()));
        entity.set利用適用開始年月日(new FlexibleDate(div.
                getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtTekiyoYMD().getFromValue().toDateString()));
        entity.set利用適用終了年月日(new FlexibleDate(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtTekiyoYMD().getToValue().toDateString()));
        entity.set標準負担区分(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getRadHyojunFutanKubun().getSelectedKey());
        entity.set標準負担額(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangaku().getValue().toString()));
        entity.set標準適用開始年月日(new FlexibleDate(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangakuTekiyoYMD().getFromValue().toDateString()));
        entity.set標準適用終了年月日(new FlexibleDate(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangakuTekiyoYMD().getToValue().toDateString()));
        if (div.getKyufuSeigenPanel().getRadKohiFutanJogenGengakuAriFlag().getSelectedKey().isEmpty()) {
            entity.set公費負担上限額減額(Boolean.FALSE);
        } else {
            entity.set公費負担上限額減額(Boolean.TRUE);
        }
        entity.set償還払化適用開始年月日(new FlexibleDate(div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD().
                getFromValue().toDateString()));
        entity.set償還払化適用終了年月日(new FlexibleDate(div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD().
                getToValue().toDateString()));
        entity.set給付率引下げ適用開始年月日(new FlexibleDate(div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage().
                getFromValue().toDateString()));
        entity.set給付率引下げ適用終了年月日(new FlexibleDate(div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage().
                getToValue().toDateString()));
        entity.set認定申請中区分(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getRadTokuteiNyushoshaNinteiShinseichuKubun().getSelectedKey());
        entity.setｻｰﾋﾞｽ区分(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getRadTokuteiNyushoshaKaigoServiceKubun().getSelectedKey());
        entity.set特例減額措置対象(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getRadKaizeisoTokureiGengakuSochiTaishoFlag().getSelectedKey());
        entity.set食費負担限度額(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtShokuhiFutanGendogaku().getValue().toString()));
        entity.setﾕﾆｯﾄ型個室(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtUnitKoshitsuGendogaku().getValue().toString()));
        entity.setﾕﾆｯﾄ型準個室(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtUnitJunKoshitsuFutanGendogaku().getValue().toString()));
        entity.set従来型個室特(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtJuraigataKoshitsuTokuyoFutanGendogaku().getValue().toString()));
        entity.set従来型個室老療(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku().getValue().toString()));
        entity.set多床室(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtTashoshitsu().getValue().toString()));
        entity.set新１(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtKyotakuhiShin1FutanGendogaku().getValue().toString()));
        entity.set新２(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtKyotakuhiShin2FutanGendogaku().getValue().toString()));
        entity.set新３(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtKyotakuhiShin3utanGendogaku().getValue().toString()));
        entity.set特定入所者適用開始年月日(new FlexibleDate(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangakuTekiyoYMD().getFromValue().toDateString()));
        entity.set特定入所者適用終了年月日(new FlexibleDate(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangakuTekiyoYMD().getToValue().toDateString()));
        entity.set広域保険者番号(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtKoikiHokenshaNo().getValue());
        entity.set老人保健市町村番号(div.getRojinHokenPanel().getTxtRojinHokenShichosonNo().getValue());
        entity.set老人保健公費負担者番号(div.getRojinHokenPanel().getTxtKohiFutanshaNo().getValue());
        entity.set老人保健受給者番号(div.getRojinHokenPanel().getTxtRojinHokenJukyushaNo().getValue());
        entity.set軽減率(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoFukushiHojinKeigen().getTxtKeigenritsu().getValue().toString()));
        entity.set軽減率適用開始年月日(new FlexibleDate(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtFutanGendogakuTekiyoYMD().getFromValue().toDateString()));
        entity.set軽減率適用終了年月日(new FlexibleDate(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtFutanGendogakuTekiyoYMD().getFromValue().toDateString()));
        if (div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().getSelectedKey().isEmpty()) {
            entity.set小規模居宅ｻｰﾋﾞｽ利用(Boolean.FALSE);
        } else {
            entity.set小規模居宅ｻｰﾋﾞｽ利用(Boolean.TRUE);
        }
        entity.set二次予防事業区分(div.getNijiyoboJigyoPanel().getRadNijiyoboJigyoKubun().getSelectedKey());
        entity.set二次予防有効期間開始年月日(new FlexibleDate(div.getNijiyoboJigyoPanel().
                getTxtNijiyoboJigyoYukoDateRange().getFromValue().toDateString()));
        entity.set二次予防有効期間終了年月日(new FlexibleDate(div.getNijiyoboJigyoPanel().
                getTxtNijiyoboJigyoYukoDateRange().getToValue().toDateString()));
        entity.set申請種別(div.getYokaigoNinteiPanel().getRadShinseiShubetsu().getSelectedKey());
        entity.set変更申請中区分(div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun().getSelectedKey());
        entity.set申請年月日(new FlexibleDate(div.getYokaigoNinteiPanel().getTxtShinseiYMD().getValue().toString()));
        entity.set国保保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().getTxtKokuhoHokenshaNo().getValue());
        entity.set国保被保険者証番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().getTxtKokuhoHiHokenshaNo().getValue());
        entity.set国保個人番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().getTxtKokuhoKojinNo().getValue());
        entity.set後期高齢保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokiKoureiPanel().
                getTxtKokikoureiIryoHiHokenshaNo().getValue());
        entity.set後期高齢被保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokiKoureiPanel().
                getTxtKokiKoureiIryoHokenshaNo().getValue());
        entity.set住特対象者区分(div.getJushochiTokureiPanel().getRadJushochiTokureiTaishoshaKubun().getSelectedKey());
        entity.set住特施設所在保険者番号(div.getJushochiTokureiPanel().getHokenshaJohoPanel().
                getTxtShisetsuShozaiHokenjaNo().getValue());
        entity.set住特適用開始年月日(new FlexibleDate(div.getJushochiTokureiPanel().
                getTxtJushochiTokureiTekiyoYMD().getFromValue().toDateString()));
        entity.set住特適用終了年月日(new FlexibleDate(div.getJushochiTokureiPanel().
                getTxtJushochiTokureiTekiyoYMD().getToValue().toDateString()));
        entity.set二割負担適用開始年月日(new FlexibleDate(div.getRiyosyaFutanWariaiPanel().
                getTxtRiyosyaFutanWariaiYukoYMD().getFromValue().toDateString()));
        entity.set二割負担適用終了年月日(new FlexibleDate(div.getRiyosyaFutanWariaiPanel().
                getTxtRiyosyaFutanWariaiYukoYMD().getToValue().toDateString()));
        entity.set訂正年月日(new FlexibleDate(div.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD().getValue().toDateString()));
        entity.set訂正区分コード(div.getJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().getSelectedKey());
        //TODO dummy
//        JukyushaIdoRenrakuhyoSakusei business = JukyushaIdoRenrakuhyoSakusei.createInstance();
//        JukyushaIdoRenrakuhyoTorokuEntity entityReturn = business.出力用受給者訂正情報Entity(entity);
//        return entityReturn;
        return entity;
    }

    /**
     * 出力用受給者訂正情報Entityをを取得のメソッドです。
     *
     * @return JukyushaIdoRenrakuhyoTorokuEntity
     */
    public JukyushaIdoRenrakuhyoTorokuEntity get受給者異動連絡票Entity() {
        JukyushaIdoRenrakuhyoTorokuEntity entity = new JukyushaIdoRenrakuhyoTorokuEntity();
        entity.set証記載保険者番号(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShoKisaiHokenshaNo().getValue());
        entity.set被保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().getTxtKokuhoHiHokenshaNo().getValue());
        entity.set異動年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().getValue());
        entity.set異動区分(div.getJukyushaIdoRenrakuhyoKihonJoho().getRadIdoKubun().getSelectedKey());
        entity.set性別(div.getJukyushaIdoRenrakuhyoKihonJoho().getRadSeibetsu().getSelectedKey());
        entity.set異動事由(div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().getSelectedKey());
        entity.set被保険者氏名カナ(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNameKana().getValue());
        entity.set生年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtUmareYMD().getValue());
        entity.set資格取得年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuShutokuYMD().getValue());
        entity.set資格喪失年月日(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuSoshitsuYMD().getValue());
        entity.setみなし区分(div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun().getSelectedKey());
        entity.set要介護状態区分(div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().getSelectedKey());
        entity.set有効期間開始年月日(new FlexibleDate(div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().
                getFromValue().toDateString()));
        entity.set有効期間終了年月日(new FlexibleDate(div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().
                getToValue().toDateString()));
        entity.set支給限度基準額1(new RString(div.getShikyuGendoKijungakuPanel().
                getTxtHomonTsushoServiceShikyuGendoKijungaku().getValue().toString()));
        entity.set上限管理適用開始年月日１(new FlexibleDate(div.getShikyuGendoKijungakuPanel().
                getTxtHomonTsushoServiceJogenKanriTekiyoYMD().getFromValue().toDateString()));
        entity.set上限管理終了年月日１(new FlexibleDate(div.getShikyuGendoKijungakuPanel().
                getTxtHomonTsushoServiceJogenKanriTekiyoYMD().getToValue().toDateString()));
        entity.set支給限度基準額２(new RString(div.getShikyuGendoKijungakuPanel().
                getTxtTankiNyushoServiceShikyuGendoKijungaku().getValue().toString()));
        entity.set上限管理適用開始年月日２(new FlexibleDate(div.getShikyuGendoKijungakuPanel().
                getTxtTankinyushoServiceJogenKanriTekiyoYMD().getFromValue().toDateString()));
        entity.set上限管理終了年月日２(new FlexibleDate(div.getShikyuGendoKijungakuPanel().
                getTxtTankinyushoServiceJogenKanriTekiyoYMD().getToValue().toDateString()));
        entity.set計画作成区分(div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().getSelectedKey());
        entity.set居宅支援事業者番号(div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().getValue());
        entity.set居宅適用開始年月日(new FlexibleDate(div.getKyotakuServicePlanPanel().
                getTxtKyotakuServiceTekiyoYMD().getFromValue().toDateString()));
        entity.set居宅適用終了年月日(new FlexibleDate(div.getKyotakuServicePlanPanel().
                getTxtKyotakuServiceTekiyoYMD().getToValue().toDateString()));
        entity.set減免申請中区分(div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun().getSelectedKey());
        entity.set利用者負担区分(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getRadRiyoshaFutanKubunCode().getSelectedKey());
        entity.set利用給付率(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtKyufuritsu().getValue().toString()));
        entity.set利用適用開始年月日(new FlexibleDate(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtTekiyoYMD().getFromValue().toDateString()));
        entity.set利用適用終了年月日(new FlexibleDate(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtTekiyoYMD().getToValue().toDateString()));
        entity.set標準負担区分(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getRadHyojunFutanKubun().getSelectedKey());
        entity.set標準負担額(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangaku().getValue().toString()));
        entity.set標準適用開始年月日(new FlexibleDate(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangakuTekiyoYMD().getFromValue().toDateString()));
        entity.set標準適用終了年月日(new FlexibleDate(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangakuTekiyoYMD().getToValue().toDateString()));
        if (div.getKyufuSeigenPanel().getRadKohiFutanJogenGengakuAriFlag().getSelectedKey().isEmpty()) {
            entity.set公費負担上限額減額(Boolean.FALSE);
        } else {
            entity.set公費負担上限額減額(Boolean.TRUE);
        }
        entity.set償還払化適用開始年月日(new FlexibleDate(div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD().
                getFromValue().toDateString()));
        entity.set償還払化適用終了年月日(new FlexibleDate(div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD().
                getToValue().toDateString()));
        entity.set給付率引下げ適用開始年月日(new FlexibleDate(div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage().
                getFromValue().toDateString()));
        entity.set給付率引下げ適用終了年月日(new FlexibleDate(div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage().
                getToValue().toDateString()));
        entity.set認定申請中区分(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getRadTokuteiNyushoshaNinteiShinseichuKubun().getSelectedKey());
        entity.setｻｰﾋﾞｽ区分(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getRadTokuteiNyushoshaKaigoServiceKubun().getSelectedKey());
        entity.set特例減額措置対象(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getRadKaizeisoTokureiGengakuSochiTaishoFlag().getSelectedKey());
        entity.set食費負担限度額(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtShokuhiFutanGendogaku().getValue().toString()));
        entity.setﾕﾆｯﾄ型個室(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtUnitKoshitsuGendogaku().getValue().toString()));
        entity.setﾕﾆｯﾄ型準個室(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtUnitJunKoshitsuFutanGendogaku().getValue().toString()));
        entity.set従来型個室特(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtJuraigataKoshitsuTokuyoFutanGendogaku().getValue().toString()));
        entity.set従来型個室老療(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku().getValue().toString()));
        entity.set多床室(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtTashoshitsu().getValue().toString()));
        entity.set新１(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin1FutanGendogaku().getValue().toString()));
        entity.set新２(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin2FutanGendogaku().getValue().toString()));
        entity.set新３(new RString(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin3utanGendogaku().getValue().toString()));
        entity.set特定入所者適用開始年月日(new FlexibleDate(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangakuTekiyoYMD().getFromValue().toDateString()));
        entity.set特定入所者適用終了年月日(new FlexibleDate(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoHyojunFutan().getTxtFutangakuTekiyoYMD().getToValue().toDateString()));
        entity.set広域保険者番号(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtKoikiHokenshaNo().getValue());
        entity.set老人保健市町村番号(div.getRojinHokenPanel().getTxtRojinHokenShichosonNo().getValue());
        entity.set老人保健公費負担者番号(div.getRojinHokenPanel().getTxtKohiFutanshaNo().getValue());
        entity.set老人保健受給者番号(div.getRojinHokenPanel().getTxtRojinHokenJukyushaNo().getValue());
        entity.set軽減率(new RString(div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoFukushiHojinKeigen().getTxtKeigenritsu().getValue().toString()));
        entity.set軽減率適用開始年月日(new FlexibleDate(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtFutanGendogakuTekiyoYMD().getFromValue().toDateString()));
        entity.set軽減率適用終了年月日(new FlexibleDate(div.getGemmenGengakuPanel().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                getTxtFutanGendogakuTekiyoYMD().getFromValue().toDateString()));
        if (div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().getSelectedKey().isEmpty()) {
            entity.set小規模居宅ｻｰﾋﾞｽ利用(Boolean.FALSE);
        } else {
            entity.set小規模居宅ｻｰﾋﾞｽ利用(Boolean.TRUE);
        }
        entity.set二次予防事業区分(div.getNijiyoboJigyoPanel().getRadNijiyoboJigyoKubun().getSelectedKey());
        entity.set二次予防有効期間開始年月日(new FlexibleDate(div.getNijiyoboJigyoPanel().
                getTxtNijiyoboJigyoYukoDateRange().getFromValue().toDateString()));
        entity.set二次予防有効期間終了年月日(new FlexibleDate(div.getNijiyoboJigyoPanel().
                getTxtNijiyoboJigyoYukoDateRange().getToValue().toDateString()));
        entity.set申請種別(div.getYokaigoNinteiPanel().getRadShinseiShubetsu().getSelectedKey());
        entity.set変更申請中区分(div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun().getSelectedKey());
        entity.set申請年月日(new FlexibleDate(div.getYokaigoNinteiPanel().getTxtShinseiYMD().getValue().toString()));
        entity.set国保保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().getTxtKokuhoHokenshaNo().getValue());
        entity.set国保被保険者証番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().getTxtKokuhoHiHokenshaNo().getValue());
        entity.set国保個人番号(div.getKokiKoureiIryoHokenshaPanel().getKokuhoPanel().getTxtKokuhoKojinNo().getValue());
        entity.set後期高齢保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokiKoureiPanel().
                getTxtKokikoureiIryoHiHokenshaNo().getValue());
        entity.set後期高齢被保険者番号(div.getKokiKoureiIryoHokenshaPanel().getKokiKoureiPanel().
                getTxtKokiKoureiIryoHokenshaNo().getValue());
        entity.set住特対象者区分(div.getJushochiTokureiPanel().getRadJushochiTokureiTaishoshaKubun().getSelectedKey());
        entity.set住特施設所在保険者番号(div.getJushochiTokureiPanel().getHokenshaJohoPanel().
                getTxtShisetsuShozaiHokenjaNo().getValue());
        entity.set住特適用開始年月日(new FlexibleDate(div.getJushochiTokureiPanel().
                getTxtJushochiTokureiTekiyoYMD().getFromValue().toDateString()));
        entity.set住特適用終了年月日(new FlexibleDate(div.getJushochiTokureiPanel().
                getTxtJushochiTokureiTekiyoYMD().getToValue().toDateString()));
        entity.set二割負担適用開始年月日(new FlexibleDate(div.getRiyosyaFutanWariaiPanel().
                getTxtRiyosyaFutanWariaiYukoYMD().getFromValue().toDateString()));
        entity.set二割負担適用終了年月日(new FlexibleDate(div.getRiyosyaFutanWariaiPanel().
                getTxtRiyosyaFutanWariaiYukoYMD().getToValue().toDateString()));
        entity.set送付年月(div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtSofuYM().getValue().getYearMonth());
        return entity;
    }
}
