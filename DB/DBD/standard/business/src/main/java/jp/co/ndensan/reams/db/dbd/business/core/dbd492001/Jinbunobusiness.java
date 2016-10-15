/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd492001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.OutFilekekka;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.JinbunoQurirumirisutofairuYishiteburuEntity;

/**
 * 進捗の取込みリストファイル一時テーブルビジネスクラスです
 *
 * @reamsid_L DBD-1510-030 x_xuliang
 */
public class Jinbunobusiness {

    /**
     * 進捗の取込みリストファイル一時テーブルをセット
     *
     * @param entity JinbunoQurirumirisutofairuYishiteburuEntity
     * @param kekka OutFilekekka
     */
    public void editjinbun(JinbunoQurirumirisutofairuYishiteburuEntity entity, OutFilekekka kekka) {
        entity.setShikibetsukodo(kekka.get識別コード());
        entity.setShikibetsukodo_meisho(kekka.get識別コード名称());
        entity.setHokenshabango(kekka.get保険者番号());
        entity.setHihokenjabango(kekka.get被保険者番号());
        entity.setNinteishinseibi(kekka.get認定申請日());
        entity.setEdaban(kekka.get枝番());
        entity.setShinseikubunhorei(kekka.get申請区分_法令_コード());
        entity.setShinseikubunhorei_meisho(kekka.get申請区分_法令_コード名称());
        entity.setShinseikubunshinseiji(kekka.get申請区分_申請時_コード());
        entity.setShinseikubunshinseiji_meisho(kekka.get申請区分_申請時_コード名称());
        entity.setTorisakubunkodo(kekka.get取下区分コード());
        entity.setTorisakubunkodo_meisho(kekka.get取下区分コード名称());
        entity.setHihokenjakubun(kekka.get被保険者区分コード());
        entity.setHihokenjakubun_meisho(kekka.get被保険者区分コード名称());
        entity.setShinseidaikokubun(kekka.get申請代行区分コード());
        entity.setShinseidaikokubun_meisho(kekka.get申請代行区分コード名称());
        entity.setSeinengappi(kekka.get生年月日());
        entity.setNenrei(kekka.get年齢());
        entity.setSeibetsukodo(kekka.get性別コード());
        entity.setSeibetsukodo_meisho(kekka.get性別コード名称());
        entity.setHihokenjakanashimei(kekka.get被保険者ｶﾅ氏名());
        entity.setHihokenjakanjishimei(kekka.get被保険者漢字氏名());
        entity.setYubenbango(kekka.get郵便番号());
        entity.setJusho(kekka.get住所());
        entity.setTenwabango(kekka.get電話番号());
        entity.setByoinshisetsutonomeisho(kekka.get病院施設等の名称());
        entity.setByoinshisetsutonoshozaichi(kekka.get病院施設等の所在地());
        entity.setZenkainoninteishinsakaikekka(kekka.get前回の認定審査会結果());
        entity.setZenkainoninteishinsakaikekka_meisho(kekka.get前回の認定審査会結果名称());
        entity.setZenkainoninteiyukokigenkaishi(kekka.get前回の認定有効期間_開始());
        entity.setZenkainoninteiyukokigenshuryo(kekka.get前回の認定有効期間_終了());
        entity.setShujiiiryokikanbango(kekka.get主治医医療機関番号());
        entity.setShujiibango(kekka.get主治医番号());
        entity.setLkenshoiraibi(kekka.get意見書依頼日());
        entity.setLkenshonyushubi(kekka.get意見書入手日());
        entity.setLkensho_tankikioku(kekka.get意見書_短期記憶());
        entity.setLkensho_ninchinoryoku(kekka.get意見書_認知能力());
        entity.setLkensho_dentatsunoryoku(kekka.get意見書_伝達能力());
        entity.setLkensho_shokujikoi(kekka.get意見書_食事行為());
        entity.setLkensho_ninshishokoreishajiritsudo(kekka.get意見書_認知症高齢者の日常生活自立度());
        entity.setChosairaibi(kekka.get調査依頼日());
        entity.setChosajisshibi(kekka.get調査実施日());
        entity.setShiteikyotakukaigoshienjigyoshatobango(kekka.get指定居宅介護支援事業者等番号());
        entity.setLtakukubun(kekka.get委託区分());
        entity.setLtakukubun_meisho(kekka.get委託区分名称());
        entity.setNinteichosainbango(kekka.get認定調査員番号());
        entity.setNinteichosainshikakukodo(kekka.get認定調査員資格コード());
        entity.setNinteichosainshikakukodo_meisho(kekka.get認定調査員資格コード名称());
        entity.setLchijihanteibi(kekka.get一次判定日());
        entity.setLchijihanteikekka(kekka.get一次判定結果());
        entity.setLchijihanteikekka_meisho(kekka.get一次判定結果名称());
        entity.setLchijihanteikekka_ninshishokasan(kekka.get一次判定結果_認知症加算());
        entity.setLchijihanteikekka_ninshishokasan_meisho(kekka.get一次判定結果_認知症加算_名称());
        entity.setNinteishinsakaishiryosakuseibi(kekka.get認定審査会資料作成日());
        entity.setNinteishinsakaiyoteibi(kekka.get認定審査会予定日());
        entity.setGogitaibango(kekka.get合議体番号());
        entity.setShinsakaishiryobango(kekka.get審査会資料番号());
        entity.setNijihanteibi(kekka.get二次判定日());
        entity.setNijihanteikekka(kekka.get二次判定結果());
        entity.setNijihanteikekka_meisho(kekka.get二次判定結果名称());
        entity.setNinteiyukokigen_kaishi(kekka.get認定有効期間_開始());
        entity.setNinteiyukokigen_shuryo(kekka.get認定有効期間_終了());
        entity.setTokuteishippeikodo(kekka.get特定疾病コード());
        entity.setTokuteishippeikodo_meisho(kekka.get特定疾病コード名称());
        entity.setYokaigo1nobaainojotaizo(kekka.get要介護1の場合の状態像());
        entity.setYokaigo1nobaainojotaizo_meisho(kekka.get要介護1の場合の状態像名称());
        entity.setGenzainosabisukubunkodo(kekka.get現在のサービス区分コード());
        entity.setGenzainosabisukubunkodo_meisho(kekka.get現在のサービス区分コード名称());
        entity.setGenzainojokyo(kekka.get現在の状況());
        entity.setGenzainojokyo_meisho(kekka.get現在の状況名称());
    }
}
