/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_GemmenShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_HenkoShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_HyojunFutanKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JutokuJigyoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_NijiyoboJigyoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_NinteiShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_RiyoshaFutanKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ServiceKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ShinseiShubetsuCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TeiseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TokureiGengakuSochiTaisho;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyotoroku.JukyushaTeiseiRenrakuhyoToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 受給者異動連絡票関連共有子Divのハンドラクラスです。
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public class JukyushaIdoRenrakuhyoHandler {

    private final JukyushaIdoRenrakuhyoDiv div;
    private static final RString 新規KEY = new RString("new");
    private static final RString 変更KEY = new RString("change");
    private static final RString 終了KEY = new RString("end");
    private static final RString 受給資格取得KEY = new RString("shutoku");
    private static final RString 受給資格喪失KEY = new RString("soshitsu");
    private static final RString 広域連合における受給者の市町村間転居異動KEY = new RString("koikinaiIdo");
    private static final RString 合併による新規KEY = new RString("shinki");
    private static final RString その他異動KEY = new RString("sonotaIdo");
    private static final RString 空KEY = new RString("space");
    private static final RString 男KEY = new RString("man");
    private static final RString 女KEY = new RString("woman");
    private static final RString 修正KEY = new RString("key0");
    private static final RString 削除KEY = new RString("key1");
    private static final RString 更新KEY = new RString("update");
    private static final RString 職権KEY = new RString("shokken");
    private static final RString なしKEY = new RString("nashi");
    private static final RString ありKEY = new RString("ari");
    private static final RString 未選択KEY = new RString("selectnashi");
    private static final RString 非該当KEY = new RString("higaito");
    private static final RString 経過的要介護KEY = new RString("yoshienKeikatekiYokaigo");
    private static final RString 要支援1KEY = new RString("yoshien1");
    private static final RString 要支援2KEY = new RString("yoshien2");
    private static final RString 要介護1KEY = new RString("yokaigo1");
    private static final RString 要介護2KEY = new RString("yokaigo2");
    private static final RString 要介護3KEY = new RString("yokaigo3");
    private static final RString 要介護4KEY = new RString("yokaigo4");
    private static final RString 要介護5KEY = new RString("yokaigo5");
    private static final RString 申請無KEY = new RString("shinseiNashi");
    private static final RString 申請中KEY = new RString("shinseiTyu");
    private static final RString 決定済KEY = new RString("ketteiZumi");
    private static final RString 通常認定KEY = new RString("normal");
    private static final RString みなし認定KEY = new RString("minashi");
    private static final RString やむを得ない事由KEY = new RString("yamuwoenai");
    private static final RString 計画作成区分未選択KEY = new RString("selectNot");
    private static final RString 居宅介護支援事業所作成KEY = new RString("kyotakuShienJigyosha");
    private static final RString 自己作成KEY = new RString("myself");
    private static final RString 介護予防支援事業所作成KEY = new RString("kaigoyoboJigyosha");
    private static final RString 該当KEY = new RString("gaito");
    private static final RString 標準負担KEY = new RString("standard");
    private static final RString 特定標準負担KEY = new RString("tokuteiStandard");
    private static final RString 利用者負担KEY = new RString("riyosha");
    private static final RString 旧措置入所者利用者負担KEY = new RString("kyushochiNyushosha");
    private static final RString 通常受給者KEY = new RString("kyusochiNyushosha");
    private static final RString 旧措置入所者KEY = new RString("standard");
    private static final RString 事業区分未選択KEY = new RString("selnashi");
    private static final RString 星 = new RString("*");
    private static final RString 新規モード = new RString("新規モード");
    private static final RString 訂正モード = new RString("訂正モード");
    private static final RString 再発行モード = new RString("再発行モード");
    private static final RString 照会モード = new RString("照会モード");
    private static final RString 居宅サービス_旧訪問通所 = new RString("居宅サービス（旧訪問通所）");
    private static final RString 旧短期入所サービス = new RString("（旧短期入所サービス）");
    private static final RString WIDTH = new RString("220");

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
     * @param 論理削除フラグ RString
     * @param 異動日 FlexibleDate
     */
    public void initialize(RString 処理モード, ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号,
            int 履歴番号, boolean 論理削除フラグ, FlexibleDate 異動日) {
        setDivModel(処理モード);
        set支給限度基準額エリア項目名称(異動日);
        div.setHihokenshaNo(DataPassingConverter.serialize(被保険者番号));
        JukyushaIdoRenrakuhyo 受給者異動情報 = JukyushaTeiseiRenrakuhyoToroku.createInstance().
                getJukyushaIdoJoho(処理モード, 識別コード, 被保険者番号, 履歴番号, 論理削除フラグ, 異動日);
        if (受給者異動情報 == null) {
            return;
        }
        if (新規モード.equals(処理モード)) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShoKisaiHokenshaNo().setValue(受給者異動情報.get証記載保険者番号().value());
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNo().setValue(被保険者番号.value());
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().setValue(受給者異動情報.get異動年月日());
            if (Seibetsu.男.getコード().equals(受給者異動情報.get性別コード())) {
                div.getJukyushaIdoRenrakuhyoKihonJoho().getRadSeibetsu().setSelectedKey(男KEY);
            } else if (Seibetsu.女.getコード().equals(受給者異動情報.get性別コード())) {
                div.getJukyushaIdoRenrakuhyoKihonJoho().getRadSeibetsu().setSelectedKey(女KEY);
            }
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNameKana().setValue(受給者異動情報.get被保険者氏名カナ());
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtUmareYMD().setValue(受給者異動情報.get生年月日());
            if (受給者異動情報.get訂正年月日() != null && !受給者異動情報.get訂正年月日().isEmpty()) {
                div.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD().setValue(new RDate(受給者異動情報.get訂正年月日().toString()));
            }
            return;
        }
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtIdoYMD().setValue(受給者異動情報.get異動年月日());
        if (JukyushaIF_IdoKubunCode.新規.getコード().equals(受給者異動情報.get異動区分コード())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getRadIdoKubun().setSelectedKey(新規KEY);
        } else if (JukyushaIF_IdoKubunCode.変更.getコード().equals(受給者異動情報.get異動区分コード())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getRadIdoKubun().setSelectedKey(変更KEY);
        } else if (JukyushaIF_IdoKubunCode.終了.getコード().equals(受給者異動情報.get異動区分コード())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getRadIdoKubun().setSelectedKey(終了KEY);
        }
        if (JukyushaIF_JukyushaIdoJiyu.受給資格取得.getコード().equals(受給者異動情報.get受給者異動事由())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().setSelectedKey(受給資格取得KEY);
        } else if (JukyushaIF_JukyushaIdoJiyu.受給資格喪失.getコード().equals(受給者異動情報.get受給者異動事由())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().setSelectedKey(受給資格喪失KEY);
        } else if (JukyushaIF_JukyushaIdoJiyu.広域連合における受給者の市町村間転居異動.getコード().equals(受給者異動情報.get受給者異動事由())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().setSelectedKey(広域連合における受給者の市町村間転居異動KEY);
        } else if (JukyushaIF_JukyushaIdoJiyu.合併による新規.getコード().equals(受給者異動情報.get受給者異動事由())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().setSelectedKey(合併による新規KEY);
        } else if (JukyushaIF_JukyushaIdoJiyu.その他異動.getコード().equals(受給者異動情報.get受給者異動事由())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().setSelectedKey(その他異動KEY);
        } else {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getDdlJukyushaIdoJiyu().setSelectedKey(空KEY);
        }
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNo().setValue(被保険者番号.value());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHiHokenshaNameKana().setValue(受給者異動情報.get被保険者氏名カナ());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtUmareYMD().setValue(受給者異動情報.get生年月日());
        if (Seibetsu.男.getコード().equals(受給者異動情報.get性別コード())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getRadSeibetsu().setSelectedKey(男KEY);
        } else if (Seibetsu.女.getコード().equals(受給者異動情報.get性別コード())) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getRadSeibetsu().setSelectedKey(女KEY);
        }
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuShutokuYMD().setValue(受給者異動情報.get資格取得年月日());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuSoshitsuYMD().setValue(受給者異動情報.get資格喪失年月日());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShoKisaiHokenshaNo().setValue(受給者異動情報.get証記載保険者番号().value());
        div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtKoikiHokenshaNo().setValue(受給者異動情報.get広域連合_政令市_保険者番号().value());
        if (受給者異動情報.get送付年月() != null) {
            div.getJukyushaIdoRenrakuhyoKihonJoho().getTxtSofuYM().setValue(new FlexibleDate(受給者異動情報.get送付年月().toDateString()));
        }
        if (受給者異動情報.get訂正年月日() != null) {
            div.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD().setValue(new RDate(受給者異動情報.get訂正年月日().toString()));
        }
        if (JukyushaIF_TeiseiKubunCode.修正.getコード().equals(受給者異動情報.get訂正区分コード())) {
            div.getJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().setSelectedKey(修正KEY);
        } else if (JukyushaIF_TeiseiKubunCode.削除.getコード().equals(受給者異動情報.get訂正区分コード())) {
            div.getJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().setSelectedKey(削除KEY);
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
    }

    private void setDivModel(RString 処理モード) {
        if (新規モード.equals(処理モード)) {
            div.setMode_DisplayMode(JukyushaIdoRenrakuhyoDiv.DisplayMode.shinki);
        } else if (訂正モード.equals(処理モード)) {
            div.setMode_DisplayMode(JukyushaIdoRenrakuhyoDiv.DisplayMode.teisei);
        } else if (再発行モード.equals(処理モード)) {
            div.setMode_DisplayMode(JukyushaIdoRenrakuhyoDiv.DisplayMode.saihakko);
        } else if (照会モード.equals(処理モード)) {
            div.setMode_DisplayMode(JukyushaIdoRenrakuhyoDiv.DisplayMode.shokai);
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
        if (JukyushaIF_ShinseiShubetsuCode.新規申請.getコード().equals(受給者異動情報.get申請種別コード())) {
            div.getYokaigoNinteiPanel().getRadShinseiShubetsu().setSelectedKey(新規KEY);
        } else if (JukyushaIF_ShinseiShubetsuCode.更新申請.getコード().equals(受給者異動情報.get申請種別コード())) {
            div.getYokaigoNinteiPanel().getRadShinseiShubetsu().setSelectedKey(更新KEY);
        } else if (JukyushaIF_ShinseiShubetsuCode.変更申請.getコード().equals(受給者異動情報.get申請種別コード())) {
            div.getYokaigoNinteiPanel().getRadShinseiShubetsu().setSelectedKey(変更KEY);
        } else if (JukyushaIF_ShinseiShubetsuCode.職権.getコード().equals(受給者異動情報.get申請種別コード())) {
            div.getYokaigoNinteiPanel().getRadShinseiShubetsu().setSelectedKey(職権KEY);
        } else if (受給者異動情報.get申請種別コード() == null || 受給者異動情報.get申請種別コード().isEmpty()) {
            div.getYokaigoNinteiPanel().getRadShinseiShubetsu().setSelectedKey(なしKEY);
        }
        if (YokaigoJotaiKubun99.非該当.getコード().equals(受給者異動情報.get要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(非該当KEY);
        } else if (YokaigoJotaiKubun99.経過的要介護.getコード().equals(受給者異動情報.get要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(経過的要介護KEY);
        } else if (YokaigoJotaiKubun06.要支援1.getコード().equals(受給者異動情報.get要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(要支援1KEY);
        } else if (YokaigoJotaiKubun06.要支援2.getコード().equals(受給者異動情報.get要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(要支援2KEY);
        } else if (YokaigoJotaiKubun06.要介護1.getコード().equals(受給者異動情報.get要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(要介護1KEY);
        } else if (YokaigoJotaiKubun06.要介護2.getコード().equals(受給者異動情報.get要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(要介護2KEY);
        } else if (YokaigoJotaiKubun06.要介護3.getコード().equals(受給者異動情報.get要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(要介護3KEY);
        } else if (YokaigoJotaiKubun06.要介護4.getコード().equals(受給者異動情報.get要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(要介護4KEY);
        } else if (YokaigoJotaiKubun06.要介護5.getコード().equals(受給者異動情報.get要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(要介護5KEY);
        } else {
            div.getYokaigoNinteiPanel().getDdlYokaigoJotaiKubun().setSelectedKey(空KEY);
        }

        if (JukyushaIF_HenkoShinseichuKubunCode.申請無し.getコード().equals(受給者異動情報.get変更申請中区分コード())) {
            div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun().setSelectedKey(申請無KEY);
        } else if (JukyushaIF_HenkoShinseichuKubunCode.申請中.getコード().equals(受給者異動情報.get変更申請中区分コード())) {
            div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun().setSelectedKey(申請中KEY);
        } else if (JukyushaIF_HenkoShinseichuKubunCode.決定済み.getコード().equals(受給者異動情報.get変更申請中区分コード())) {
            div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun().setSelectedKey(決定済KEY);
        } else if (受給者異動情報.get変更申請中区分コード() == null || 受給者異動情報.get変更申請中区分コード().isEmpty()) {
            div.getYokaigoNinteiPanel().getRadHenkoShinseichuKubun().setSelectedKey(なしKEY);
        }
        if (受給者異動情報.get認定有効期間開始年月日() != null) {
            div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().setFromValue(
                    new RDate(受給者異動情報.get認定有効期間開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get認定有効期間終了年月日()) && 受給者異動情報.get認定有効期間終了年月日() != null) {
            div.getYokaigoNinteiPanel().getTxtNinteiYukoKikanYMD().setToValue(
                    new RDate(受給者異動情報.get認定有効期間終了年月日().toString()));
        }
        if (MinashiCode.通常の認定.getコード().equals(受給者異動情報.getみなし要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun().setSelectedKey(通常認定KEY);
        } else if (MinashiCode.みなし認定_旧措置入所者.getコード().equals(受給者異動情報.getみなし要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun().setSelectedKey(みなし認定KEY);
        } else if (MinashiCode.やむを得ない事由.getコード().equals(受給者異動情報.getみなし要介護状態区分コード())) {
            div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun().setSelectedKey(やむを得ない事由KEY);
        } else if (受給者異動情報.getみなし要介護状態区分コード() == null || 受給者異動情報.getみなし要介護状態区分コード().isEmpty()) {
            div.getYokaigoNinteiPanel().getRadMinashiYokaigoJotaiKubun().setSelectedKey(なしKEY);
        }
    }

    private void set支給限度基準額エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        div.getShikyuGendoKijungakuPanel().getTxtHomonTsushoServiceShikyuGendoKijungaku().setValue(
                new Decimal(受給者異動情報.get訪問通所サービス支給限度基準額()));
        if (受給者異動情報.get訪問通所サービス上限管理適用期間開始年月日() != null) {
            div.getShikyuGendoKijungakuPanel().getTxtHomonTsushoServiceJogenKanriTekiyoYMD().setFromValue(
                    new RDate(受給者異動情報.get訪問通所サービス上限管理適用期間開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get訪問通所サービス上限管理適用期間終了年月日()) && 受給者異動情報.get訪問通所サービス上限管理適用期間終了年月日() != null) {
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
        if (!星.equals(受給者異動情報.get居宅サービス計画作成区分コード())) {
            if (JukyushaIF_KeikakuSakuseiKubunCode.居宅介護支援事業所作成.getコード().equals(
                    受給者異動情報.get居宅サービス計画作成区分コード())) {
                div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().setSelectedKey(居宅介護支援事業所作成KEY);
            } else if (JukyushaIF_KeikakuSakuseiKubunCode.自己作成.getコード().equals(
                    受給者異動情報.get居宅サービス計画作成区分コード())) {
                div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().setSelectedKey(自己作成KEY);
            } else if (JukyushaIF_KeikakuSakuseiKubunCode.介護予防支援事業所_地域包括支援センター作成.getコード().equals(
                    受給者異動情報.get居宅サービス計画作成区分コード())) {
                div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().setSelectedKey(介護予防支援事業所作成KEY);
            } else {
                div.getKyotakuServicePlanPanel().getRadKyotakuServiceSakuseiKubun().setSelectedKey(計画作成区分未選択KEY);
            }
        }
        if (!星.equals(受給者異動情報.get居宅介護支援事業所番号())) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().setValue(
                    受給者異動情報.get居宅介護支援事業所番号());
        }
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
        if (!星.equals(受給者異動情報.get居宅サービス計画適用開始年月日()) && 受給者異動情報.get居宅サービス計画適用開始年月日() != null) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().setFromValue(
                    new RDate(受給者異動情報.get居宅サービス計画適用開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get居宅サービス計画適用終了年月日()) && 受給者異動情報.get居宅サービス計画適用終了年月日() != null) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().setToValue(
                    new RDate(受給者異動情報.get居宅サービス計画適用終了年月日().toString()));
        }
        if (受給者異動情報.is小多機能居宅介護利用開始月利用有フラグ()) {
            div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().setSelectedKey(なしKEY);
        } else {
            div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().setSelectedKey(ありKEY);
        }
    }

    private void set住所地特例エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        if (!星.equals(受給者異動情報.get住所地特例対象者区分コード())) {
            if (JukyushaIF_JutokuJigyoKubunCode.該当.getコード().equals(受給者異動情報.get住所地特例対象者区分コード())) {
                div.getJushochiTokureiPanel().getRadJushochiTokureiTaishoshaKubun().setSelectedKey(該当KEY);
            } else if (JukyushaIF_JutokuJigyoKubunCode.非該当.getコード().equals(受給者異動情報.get住所地特例対象者区分コード())) {
                div.getJushochiTokureiPanel().getRadJushochiTokureiTaishoshaKubun().setSelectedKey(非該当KEY);
            } else if (受給者異動情報.get住所地特例対象者区分コード() == null || 受給者異動情報.get住所地特例対象者区分コード().isEmpty()) {
                div.getJushochiTokureiPanel().getRadJushochiTokureiTaishoshaKubun().setSelectedKey(なしKEY);
            }
        }
        if (!星.equals(受給者異動情報.get住所地特例適用開始日()) && 受給者異動情報.get住所地特例適用開始日() != null) {
            div.getJushochiTokureiPanel().getTxtJushochiTokureiTekiyoYMD().setFromValue(
                    new RDate(受給者異動情報.get住所地特例適用開始日().toString()));
        }
        if (!星.equals(受給者異動情報.get住所地特例適用終了日()) && 受給者異動情報.get住所地特例適用終了日() != null) {
            div.getJushochiTokureiPanel().getTxtJushochiTokureiTekiyoYMD().setToValue(
                    new RDate(受給者異動情報.get住所地特例適用終了日().toString()));
        }
        div.getJushochiTokureiPanel().getHokenshaJohoPanel().getTxtShisetsuShozaiHokenjaNo().setValue(受給者異動情報.get施設所在保険者番号());
    }

    private void set減免_減額エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        if (JukyushaIF_GemmenShinseichuKubunCode.申請無し.getコード().equals(受給者異動情報.get減免申請中区分コード())) {
            div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun().setSelectedKey(申請無KEY);
        } else if (JukyushaIF_GemmenShinseichuKubunCode.申請中.getコード().equals(受給者異動情報.get減免申請中区分コード())) {
            div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun().setSelectedKey(申請中KEY);
        } else if (JukyushaIF_GemmenShinseichuKubunCode.決定済み.getコード().equals(受給者異動情報.get減免申請中区分コード())) {
            div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun().setSelectedKey(決定済KEY);
        } else if (受給者異動情報.get減免申請中区分コード() == null || 受給者異動情報.get減免申請中区分コード().isEmpty()) {
            div.getGemmenGengakuPanel().getRadGemmenShinseichuKubun().setSelectedKey(なしKEY);
        }
        if (!星.equals(受給者異動情報.get利用者負担区分コード())) {
            if (JukyushaIF_RiyoshaFutanKubunCode.利用者負担.getコード().equals(受給者異動情報.get利用者負担区分コード())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                        getJukyushaIdoRenrakuhyoRiyoshaFutan().getRadRiyoshaFutanKubunCode().setSelectedKey(標準負担KEY);
            } else if (JukyushaIF_RiyoshaFutanKubunCode.旧措置入所者利用者負担.getコード().equals(受給者異動情報.get利用者負担区分コード())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                        getJukyushaIdoRenrakuhyoRiyoshaFutan().getRadRiyoshaFutanKubunCode().setSelectedKey(特定標準負担KEY);
            } else if (受給者異動情報.get利用者負担区分コード() == null || 受給者異動情報.get利用者負担区分コード().isEmpty()) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                        getJukyushaIdoRenrakuhyoRiyoshaFutan().getRadRiyoshaFutanKubunCode().setSelectedKey(なしKEY);
            }
        }
        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().
                getJukyushaIdoRenrakuhyoRiyoshaFutan().getTxtKyufuritsu().setValue(受給者異動情報.get給付率());
        if (!星.equals(受給者異動情報.get適用開始年月日()) && 受給者異動情報.get適用開始年月日() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoRiyoshaFutan().
                    getTxtTekiyoYMD().setFromValue(new RDate(受給者異動情報.get適用開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get適用終了年月日()) && 受給者異動情報.get適用終了年月日() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoRiyoshaFutan().
                    getTxtTekiyoYMD().setToValue(new RDate(受給者異動情報.get適用終了年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get軽減率()) && 受給者異動情報.get軽減率() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen().
                    getTxtKeigenritsu().setValue(new Decimal(受給者異動情報.get軽減率().toString()));
        }
        if (!星.equals(受給者異動情報.get軽減率適用開始年月日()) && 受給者異動情報.get軽減率適用開始年月日() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen().
                    getTxtKeigenritsuTekiyoYMD().setFromValue(new RDate(受給者異動情報.get軽減率適用開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get軽減率適用終了年月日()) && 受給者異動情報.get軽減率適用終了年月日() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen().
                    getTxtKeigenritsuTekiyoYMD().setToValue(new RDate(受給者異動情報.get軽減率適用終了年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get標準負担区分コード())) {
            if (JukyushaIF_HyojunFutanKubunCode.標準負担.getコード().equals(受給者異動情報.get標準負担区分コード())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                        getRadHyojunFutanKubun().setSelectedKey(利用者負担KEY);
            } else if (JukyushaIF_HyojunFutanKubunCode.特定標準負担.getコード().equals(受給者異動情報.get標準負担区分コード())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                        getRadHyojunFutanKubun().setSelectedKey(旧措置入所者利用者負担KEY);
            } else if (受給者異動情報.get標準負担区分コード() == null || 受給者異動情報.get標準負担区分コード().isEmpty()) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                        getRadHyojunFutanKubun().setSelectedKey(なしKEY);
            }
        }
        div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                getTxtFutangaku().setValue(受給者異動情報.get負担額());
        if (!星.equals(受給者異動情報.get負担額適用開始年月日()) && 受給者異動情報.get負担額適用開始年月日() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                    getTxtFutangakuTekiyoYMD().setFromValue(new RDate(受給者異動情報.get負担額適用開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get負担額適用終了年月日()) && 受給者異動情報.get負担額適用終了年月日() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                    getTxtFutangakuTekiyoYMD().setToValue(new RDate(受給者異動情報.get負担額適用終了年月日().toString()));
        }
        if (JukyushaIF_NinteiShinseichuKubunCode.申請無し.getコード().equals(受給者異動情報.get特定入所者認定申請中区分コード())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getRadTokuteiNyushoshaNinteiShinseichuKubun().setSelectedKey(申請無KEY);
        } else if (JukyushaIF_NinteiShinseichuKubunCode.申請中.getコード().equals(受給者異動情報.get特定入所者認定申請中区分コード())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getRadTokuteiNyushoshaNinteiShinseichuKubun().setSelectedKey(申請中KEY);
        } else if (JukyushaIF_NinteiShinseichuKubunCode.決定済み.getコード().equals(受給者異動情報.get特定入所者認定申請中区分コード())) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getRadTokuteiNyushoshaNinteiShinseichuKubun().setSelectedKey(決定済KEY);
        } else if (受給者異動情報.get特定入所者認定申請中区分コード() == null || 受給者異動情報.get特定入所者認定申請中区分コード().isEmpty()) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getRadTokuteiNyushoshaNinteiShinseichuKubun().setSelectedKey(なしKEY);
        }
        if (!星.equals(受給者異動情報.get特定入所者介護サービス区分コード())) {
            if (JukyushaIF_ServiceKubunCode.通常の受給者.getコード().equals(受給者異動情報.get特定入所者介護サービス区分コード())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadTokuteiNyushoshaKaigoServiceKubun().setSelectedKey(通常受給者KEY);
            } else if (JukyushaIF_ServiceKubunCode.通常の受給者.getコード().equals(受給者異動情報.get特定入所者介護サービス区分コード())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadTokuteiNyushoshaKaigoServiceKubun().setSelectedKey(旧措置入所者KEY);
            } else if (受給者異動情報.get特定入所者介護サービス区分コード() == null
                    || 受給者異動情報.get特定入所者介護サービス区分コード().isEmpty()) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadTokuteiNyushoshaKaigoServiceKubun().setSelectedKey(なしKEY);
            }
        }
        if (!星.equals(受給者異動情報.is課税層の特例減額措置対象フラグ())) {
            if (JukyushaIF_TokureiGengakuSochiTaisho.該当無し.getコード().equals(受給者異動情報.is課税層の特例減額措置対象フラグ())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadKaizeisoTokureiGengakuSochiTaishoFlag().setSelectedKey(なしKEY);
            } else if (JukyushaIF_TokureiGengakuSochiTaisho.該当無し.getコード().equals(受給者異動情報.is課税層の特例減額措置対象フラグ())) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadKaizeisoTokureiGengakuSochiTaishoFlag().setSelectedKey(ありKEY);
            } else if (受給者異動情報.is課税層の特例減額措置対象フラグ() == null || 受給者異動情報.is課税層の特例減額措置対象フラグ().isEmpty()) {
                div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                        getRadKaizeisoTokureiGengakuSochiTaishoFlag().setSelectedKey(未選択KEY);
            }
        }
        if (!星.equals(受給者異動情報.get食費負担限度額()) && 受給者異動情報.get食費負担限度額() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtShokuhiFutanGendogaku().setValue(new Decimal(受給者異動情報.get食費負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get負担限度額適用開始年月日()) && 受給者異動情報.get負担限度額適用開始年月日() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtFutanGendogakuTekiyoYMD().setFromValue(new RDate(受給者異動情報.get負担限度額適用開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get負担限度額適用終了年月日()) && 受給者異動情報.get負担限度額適用終了年月日() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().
                    getTxtFutanGendogakuTekiyoYMD().setToValue(new RDate(受給者異動情報.get負担限度額適用終了年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get居住費従来型個室特養等負担限度額()) && 受給者異動情報.get居住費従来型個室特養等負担限度額() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtJuraigataKoshitsuTokuyoFutanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居住費従来型個室特養等負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居住費従来型個室老健療養等負担限度額()) && 受給者異動情報.get居住費従来型個室老健療養等負担限度額() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居住費従来型個室老健療養等負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居住費多床室負担限度額()) && 受給者異動情報.get居住費多床室負担限度額() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtTashoshitsu().
                    setValue(new Decimal(受給者異動情報.get居住費多床室負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居住費ユニット型個室負担限度額()) && 受給者異動情報.get居住費ユニット型個室負担限度額() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtUnitKoshitsuGendogaku().
                    setValue(new Decimal(受給者異動情報.get居住費ユニット型個室負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居住費ユニット型準個室負担限度額()) && 受給者異動情報.get居住費ユニット型準個室負担限度額() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtUnitJunKoshitsuFutanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居住費ユニット型準個室負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居宅費_新１_負担限度額()) && 受給者異動情報.get居宅費_新１_負担限度額() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin1FutanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居宅費_新１_負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居宅費_新２_負担限度額()) && 受給者異動情報.get居宅費_新２_負担限度額() != null) {
            div.getGemmenGengakuPanel().getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getTxtKyotakuhiShin2FutanGendogaku().
                    setValue(new Decimal(受給者異動情報.get居宅費_新２_負担限度額().toString()));
        }
        if (!星.equals(受給者異動情報.get居宅費_新３_負担限度額()) && 受給者異動情報.get居宅費_新３_負担限度額() != null) {
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
            div.getKyufuSeigenPanel().getRadKohiFutanJogenGengakuAriFlag().setSelectedKey(ありKEY);
        } else {
            div.getKyufuSeigenPanel().getRadKohiFutanJogenGengakuAriFlag().setSelectedKey(なしKEY);
        }
        if (!星.equals(受給者異動情報.get償還払化開始年月日()) && 受給者異動情報.get償還払化開始年月日() != null) {
            div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD().setFromValue(new RDate(受給者異動情報.get償還払化開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get償還払化終了年月日()) && 受給者異動情報.get償還払化終了年月日() != null) {
            div.getKyufuSeigenPanel().getTxtShokanbaraikaYMD().setToValue(new RDate(受給者異動情報.get償還払化終了年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get給付率引下げ開始年月日()) && 受給者異動情報.get給付率引下げ開始年月日() != null) {
            div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage().setFromValue(new RDate(受給者異動情報.get給付率引下げ開始年月日().toString()));
        }
        if (!星.equals(受給者異動情報.get給付率引下げ終了年月日()) && 受給者異動情報.get給付率引下げ終了年月日() != null) {
            div.getKyufuSeigenPanel().getTxtKyufuritsuHikisage().setToValue(new RDate(受給者異動情報.get給付率引下げ終了年月日().toString()));
        }
    }

    private void set二割負担エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        if (!星.equals(受給者異動情報.get利用者負担割合有効開始日()) && 受給者異動情報.get利用者負担割合有効開始日() != null) {
            div.getRiyosyaFutanWariaiPanel().getTxtRiyosyaFutanWariaiYukoYMD().setFromValue(
                    new RDate(受給者異動情報.get利用者負担割合有効開始日().toString()));
        }
        if (!星.equals(受給者異動情報.get利用者負担割合有効終了日()) && 受給者異動情報.get利用者負担割合有効終了日() != null) {
            div.getRiyosyaFutanWariaiPanel().getTxtRiyosyaFutanWariaiYukoYMD().setToValue(
                    new RDate(受給者異動情報.get利用者負担割合有効終了日().toString()));
        }
    }

    private void set二次予防事業エリア(JukyushaIdoRenrakuhyo 受給者異動情報) {
        if (JukyushaIF_NijiyoboJigyoKubunCode.非該当.getコード().equals(受給者異動情報.get二次予防事業区分コード())) {
            div.getNijiyoboJigyoPanel().getRadNijiyoboJigyoKubun().setSelectedKey(非該当KEY);
        } else if (JukyushaIF_NijiyoboJigyoKubunCode.該当.getコード().equals(受給者異動情報.get二次予防事業区分コード())) {
            div.getNijiyoboJigyoPanel().getRadNijiyoboJigyoKubun().setSelectedKey(該当KEY);
        } else if (受給者異動情報.get二次予防事業区分コード() == null || 受給者異動情報.get二次予防事業区分コード().isEmpty()) {
            div.getNijiyoboJigyoPanel().getRadNijiyoboJigyoKubun().setSelectedKey(事業区分未選択KEY);
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
        if (該当KEY.equals(事業区分Key)) {
            div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange().setReadOnly(false);
        } else {
            div.getNijiyoboJigyoPanel().getTxtNijiyoboJigyoYukoDateRange().setReadOnly(true);
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
        if (計画作成区分未選択KEY.equals(計画作成区分Key)) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().setReadOnly(true);
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoName().setReadOnly(true);
            div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().setReadOnly(true);
            div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().setReadOnly(true);
        } else if (自己作成KEY.equals(計画作成区分Key)) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().setReadOnly(true);
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoName().setReadOnly(true);
            div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().setReadOnly(false);
            div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().setReadOnly(false);
        } else if (居宅介護支援事業所作成KEY.equals(計画作成区分Key)
                || 介護予防支援事業所作成KEY.equals(計画作成区分Key)) {
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().setReadOnly(false);
            div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoName().setReadOnly(false);
            div.getKyotakuServicePlanPanel().getTxtKyotakuServiceTekiyoYMD().setReadOnly(false);
            div.getKyotakuServicePlanPanel().getRadShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag().setReadOnly(false);
            RString 支援事業者番号 = div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().getValue();
            RString 計画作成区分;
            if (居宅介護支援事業所作成KEY.equals(計画作成区分Key)) {
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

    }

    /**
     * 住所地特例の保険者番号focus outのメソッドです。
     *
     */
    public void onBlur_保険者番号() {
    }
}
