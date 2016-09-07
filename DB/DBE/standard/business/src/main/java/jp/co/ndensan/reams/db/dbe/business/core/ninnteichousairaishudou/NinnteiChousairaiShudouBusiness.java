/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairaishudou;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairaishudou.NinnteiChousairaiShudouEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査依頼(手動)の項目定義クラスです。
 *
 * @reamsid_L DBE-1590-010 sunhaidi
 */
public class NinnteiChousairaiShudouBusiness {

    private final NinnteiChousairaiShudouEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity NinnteiChousairaiShudouEntity
     */
    public NinnteiChousairaiShudouBusiness(NinnteiChousairaiShudouEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 認定調査依頼履歴番号を取得します。
     *
     * @return 認定調査依頼履歴番号
     */
    public RString get認定調査依頼履歴番号() {
        return entity.getNinteichosaIraiRirekiNo();
    }

    /**
     * 認定調査依頼区分コードを取得します。
     *
     * @return 認定調査依頼区分コード
     */
    public RString get認定調査依頼区分コード() {
        return entity.getNinteichosaIraiKubunCode();
    }

    /**
     * 認定調査委託先コードを取得します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 調査委託区分を取得します。
     *
     * @return 調査委託区分
     */
    public RString get調査委託区分() {
        return entity.getChosaItakuKubun();
    }

    /**
     * 認定調査員コードを取得します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 認定調査依頼年月日を取得します。
     *
     * @return 認定調査依頼年月日
     */
    public RString get認定調査依頼年月日() {
        return entity.getNinteichosaIraiYMD();
    }

    /**
     * 認定調査期限年月日を取得します。
     *
     * @return 認定調査期限年月日
     */
    public RString get認定調査期限年月日() {
        return entity.getNinteichosaKigenYMD();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public RString get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 被保険者氏名カナを取得します。
     *
     * @return 被保険者氏名カナ
     */
    public RString get被保険者氏名カナ() {
        return entity.getHihokenshaKana();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public RString get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 訪問調査先郵便番号を取得します。
     *
     * @return 訪問調査先郵便番号
     */
    public RString get訪問調査先郵便番号() {
        return entity.getHomonChosasakiYubinNo();
    }

    /**
     * 訪問調査先住所を取得します。
     *
     * @return 訪問調査先住所
     */
    public RString get訪問調査先住所() {
        return entity.getHomonChosasakiJusho();
    }

    /**
     * 訪問調査先名称を取得します。
     *
     * @return 訪問調査先名称
     */
    public RString get訪問調査先名称() {
        return entity.getHomonChosasakiName();
    }

    /**
     * 訪問調査先電話番号を取得します。
     *
     * @return 訪問調査先電話番号
     */
    public RString get訪問調査先電話番号() {
        return entity.getHomonChosasakiTelNo();
    }

    /**
     * 調査委託先郵便番号を取得します。
     *
     * @return 調査委託先郵便番号
     */
    public RString get調査委託先郵便番号() {
        return entity.getItakusakiYubinNo();
    }

    /**
     * 調査委託先住所を取得します。
     *
     * @return 調査委託先住所
     */
    public RString get調査委託先住所() {
        return entity.getItakusakiJusho();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        return entity.getAge();
    }

    /**
     * 前回認定年月日を取得します。
     *
     * @return 前回認定年月日
     */
    public RString get前回認定年月日() {
        return entity.getZenkaiNinteiYMD();
    }

    /**
     * 前回要介護状態区分コードを取得します。
     *
     * @return 前回要介護状態区分コード
     */
    public RString get前回要介護状態区分コード() {
        return entity.getZenYokaigoKubunCode();
    }

    /**
     * 連絡先住所を取得します。
     *
     * @return 連絡先住所
     */
    public RString get連絡先住所() {
        return entity.getRenrakusakiJusho();
    }

    /**
     * 連絡先郵便番号を取得します。
     *
     * @return 連絡先郵便番号
     */
    public RString get連絡先郵便番号() {
        return entity.getRenrakusakiYubinNo();
    }

    /**
     * 連絡先電話番号を取得します。
     *
     * @return 連絡先電話番号
     */
    public RString get連絡先電話番号() {
        return entity.getRenrakusakiTelNo();
    }

    /**
     * 連絡先携帯番号を取得します。
     *
     * @return 連絡先携帯番号
     */
    public RString get連絡先携帯番号() {
        return entity.getRenrakusakiKeitaiTelNo();
    }

    /**
     * 連絡先氏名を取得します。
     *
     * @return 連絡先氏名
     */
    public RString get連絡先氏名() {
        return entity.getRenrakusakiShimei();
    }

    /**
     * 連絡先続柄を取得します。
     *
     * @return 連絡先続柄
     */
    public RString get連絡先続柄() {
        return entity.getRenrakusakiTuzukigara();
    }

    /**
     * 厚労省IF識別コードを取得します。
     *
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 認知症高齢者の日常生活自立度コードを取得します。
     *
     * @return 認知症高齢者の日常生活自立度コード
     */
    public RString get認知症高齢者自立度コード() {
        return entity.getNinchishoSeikatsuJiritsudo();
    }

    /**
     * 障害高齢者の日常生活自立度コードを取得します。
     *
     * @return 障害高齢者の日常生活自立度コード
     */
    public RString get障害高齢者自立度コード() {
        return entity.getShogaiSeikatsuJiritsudo();
    }

    /**
     * 要介護認定一次判定結果コードを取得します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public RString get要介護認定一次判定結果コード() {
        return entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 二次判定要介護状態区分コードを取得します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public RString get二次判定要介護状態区分コード() {
        return entity.getNijiHanteiYokaigoJotaiKubun();
    }

    /**
     * 二次判定年月日を取得します。
     *
     * @return 二次判定年月日
     */
    public RString get二次判定年月日() {
        return entity.getNijiHanteiYMD();
    }

    /**
     * 連番を取得します。
     *
     * @return 連番
     */
    public RString get連番() {
        return entity.getRemban();
    }

    /**
     * 調査項目を取得します。
     *
     * @return 調査項目
     */
    public RString get調査項目() {
        return entity.getResearchItem();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 直近区分を取得します。
     *
     * @return 直近区分
     */
    public RString get直近区分() {
        return entity.getChokkinKubun();
    }

    /**
     * 認定申請区分（申請時）コードを取得します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public RString get認定申請区分_申請時_コード() {
        return entity.getNinteiShinseiShinseijiKubunCd();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return entity.getShichosonCode();
    }
}
