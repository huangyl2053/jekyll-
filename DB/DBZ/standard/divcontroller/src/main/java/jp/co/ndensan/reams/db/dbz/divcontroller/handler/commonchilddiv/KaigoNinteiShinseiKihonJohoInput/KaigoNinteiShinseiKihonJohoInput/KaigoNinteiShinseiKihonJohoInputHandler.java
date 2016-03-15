/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * 介護認定申請基本情報の入力用クラスのハンドラークラスです。
 */
public class KaigoNinteiShinseiKihonJohoInputHandler {

    private static final RString KEY_認定申請理由定型文 = new RString("isExistKyakkaRiyu");
    private final KaigoNinteiShinseiKihonJohoInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定申請基本情報の入力用DIV
     */
    public KaigoNinteiShinseiKihonJohoInputHandler(KaigoNinteiShinseiKihonJohoInputDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化表示、画面項目に設定します。
     *
     * @return ResponseData
     */
    public ResponseData initialize() {
        ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> response = new ResponseData<>();
//      TODO QA852 画面初期化表示、支所ddlとグループコード設定方法不明

        setDataSource();
        div.setHdnNinteiRiyuTeikeibunKey(KEY_認定申請理由定型文);
        div.setHdnSubGyomuCode(ControlDataHolder.getSubGyomuCD().value());
        div.getTxtShinseiYMD().setValue(RDate.getNowDate());

        response.data = div;
        return response;
    }

    /**
     *
     * 画面上のドロップダウンリストへデータソースをセットします。
     */
    private void setDataSource() {
        div.getDdlShinseiShubetsu().setDataSource(get申請種別List());
        div.getDdlShinseiShubetsu().setSelectedIndex(0);
        div.getDdlShinseiKubunShinseiji().setDataSource(get申請時区分List());
        div.getDdlShinseiKubunShinseiji().setSelectedIndex(0);
        div.getDdlShinseiKubunHorei().setDataSource(get申請法令区分List());
        div.getDdlShinseiKubunHorei().setSelectedIndex(0);
        div.getDdlHihokenshaKubun().setDataSource(get被保険者区分List());
        div.getDdlHihokenshaKubun().setSelectedIndex(0);
        div.getDdlTokuteiShippei().setDataSource(get特定疾病List());
        div.getDdlTokuteiShippei().setSelectedIndex(0);
    }

    private List<KeyValueDataSource> get申請種別List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();

        dataSource.add(new KeyValueDataSource(JukyuShinseiJiyu.初回申請.code(), JukyuShinseiJiyu.初回申請.toRString()));
        dataSource.add(new KeyValueDataSource(JukyuShinseiJiyu.再申請_有効期限内.code(), JukyuShinseiJiyu.再申請_有効期限内.toRString()));
        dataSource.add(new KeyValueDataSource(JukyuShinseiJiyu.再申請_有効期限外.code(), JukyuShinseiJiyu.再申請_有効期限外.toRString()));
        dataSource.add(new KeyValueDataSource(JukyuShinseiJiyu.要介護度変更申請.code(), JukyuShinseiJiyu.要介護度変更申請.toRString()));
        dataSource.add(new KeyValueDataSource(JukyuShinseiJiyu.指定サービス種類変更申請.code(), JukyuShinseiJiyu.指定サービス種類変更申請.toRString()));
        dataSource.add(new KeyValueDataSource(JukyuShinseiJiyu.申請_法施行前.code(), JukyuShinseiJiyu.申請_法施行前.toRString()));
        dataSource.add(new KeyValueDataSource(JukyuShinseiJiyu.追加_申請なしの追加.code(), JukyuShinseiJiyu.追加_申請なしの追加.toRString()));

        return dataSource;
    }

    private List<KeyValueDataSource> get申請時区分List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();

        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.新規申請.getコード(), NinteiShinseiShinseijiKubunCode.新規申請.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.更新申請.getコード(), NinteiShinseiShinseijiKubunCode.更新申請.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.区分変更申請.getコード(), NinteiShinseiShinseijiKubunCode.区分変更申請.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.職権.getコード(), NinteiShinseiShinseijiKubunCode.職権.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.転入申請.getコード(), NinteiShinseiShinseijiKubunCode.転入申請.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード(), NinteiShinseiShinseijiKubunCode.資格喪失_死亡.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.新規申請_事前.getコード(), NinteiShinseiShinseijiKubunCode.新規申請_事前.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiShinseijiKubunCode.更新申請_事前.getコード(), NinteiShinseiShinseijiKubunCode.更新申請_事前.get名称()));

        return dataSource;
    }

    private List<KeyValueDataSource> get申請法令区分List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();

        dataSource.add(new KeyValueDataSource(NinteiShinseiHoreiCode.新規申請.getコード(), NinteiShinseiShinseijiKubunCode.新規申請.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiHoreiCode.更新申請.getコード(), NinteiShinseiShinseijiKubunCode.更新申請.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiHoreiCode.区分変更申請.getコード(), NinteiShinseiShinseijiKubunCode.区分変更申請.get名称()));
        dataSource.add(new KeyValueDataSource(NinteiShinseiHoreiCode.職権.getコード(), NinteiShinseiShinseijiKubunCode.職権.get名称()));

        return dataSource;
    }

    private List<KeyValueDataSource> get被保険者区分List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();

        dataSource.add(new KeyValueDataSource(HihokenshaKubunCode.第１号被保険者.getコード(), HihokenshaKubunCode.第１号被保険者.get名称()));
        dataSource.add(new KeyValueDataSource(HihokenshaKubunCode.第２号被保険者.getコード(), HihokenshaKubunCode.第２号被保険者.get名称()));
        dataSource.add(new KeyValueDataSource(HihokenshaKubunCode.その他.getコード(), HihokenshaKubunCode.その他.get名称()));

        return dataSource;
    }

    private List<KeyValueDataSource> get特定疾病List() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();

        dataSource.add(new KeyValueDataSource(TokuteiShippei.筋萎縮性側索硬化症.getコード(), TokuteiShippei.筋萎縮性側索硬化症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.後縦靭帯骨化症.getコード(), TokuteiShippei.後縦靭帯骨化症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.骨折を伴う骨粗鬆症.getコード(), TokuteiShippei.骨折を伴う骨粗鬆症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.多系統萎縮症.getコード(), TokuteiShippei.多系統萎縮症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.初老期における認知症.getコード(), TokuteiShippei.初老期における認知症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.脊髄小脳変性症.getコード(), TokuteiShippei.脊髄小脳変性症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.脊柱管狭窄症.getコード(), TokuteiShippei.脊柱管狭窄症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.早老症.getコード(), TokuteiShippei.早老症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症.getコード(),
                TokuteiShippei.糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.脳血管疾患.getコード(), TokuteiShippei.脳血管疾患.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.パーキンソン病関連疾患.getコード(), TokuteiShippei.パーキンソン病関連疾患.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.閉塞性動脈硬化症.getコード(), TokuteiShippei.閉塞性動脈硬化症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.関節リウマチ.getコード(), TokuteiShippei.関節リウマチ.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.慢性閉塞性肺疾患.getコード(), TokuteiShippei.慢性閉塞性肺疾患.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.両側の膝関節又は股関節に著しい変形を伴う変形性関節症.getコード(),
                TokuteiShippei.両側の膝関節又は股関節に著しい変形を伴う変形性関節症.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.がん_末期.getコード(), TokuteiShippei.がん_末期.get名称()));
        dataSource.add(new KeyValueDataSource(TokuteiShippei.特定疾病以外.getコード(), TokuteiShippei.特定疾病以外.get名称()));

        return dataSource;
    }
}
