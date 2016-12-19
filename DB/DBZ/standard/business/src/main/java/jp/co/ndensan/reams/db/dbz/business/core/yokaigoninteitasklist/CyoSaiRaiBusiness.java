/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.CyoSaiRaiRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * タスク一覧共有画面を管理するクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
public class CyoSaiRaiBusiness {

    private final CyoSaiRaiRelateEntity entity;

    /**
     * 調査依頼項目を返します。
     *
     * @param entity CyoSaiRaiRelateEntity
     */
    public CyoSaiRaiBusiness(CyoSaiRaiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請区分申請時コードを返します。
     *
     * @return 認定申請区分申請時コード
     */
    public Code get認定申請区分申請時コード() {
        return entity.getShinseijiKubunCode();
    }

    /**
     * 再調査依頼回数を返します。
     *
     * @return 再調査依頼回数
     */
    public int get再調査依頼回数() {
        return entity.getSaiChosaIraiKaisu();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo get入所施設コード() {
        return entity.getNyushoShisetsuCode();
    }

    /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    public Code get処理状態区分() {
        return entity.getShoriJotaiKubun();
    }

    /**
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.getShichosonMeisho();
    }

    /**
     * 証記載保険番号を返します。
     *
     * @return 証記載保険番号
     */
    public RString get証記載保険番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 入所施設を返します。
     *
     * @return 入所施設
     */
    public AtenaMeisho get入所施設() {
        return entity.getJigyoshaName();
    }

    /**
     * 認定調査依頼完了年月日を返します。
     *
     * @return 認定調査依頼完了年月日
     */
    public FlexibleDate get認定調査依頼完了年月日() {
        return entity.getNinteichosaIraiKanryoYMD();
    }

    /**
     * 依頼書出力年月日を返します。
     *
     * @return 依頼書出力年月日
     */
    public FlexibleDate get依頼書出力年月日() {
        return entity.getIraishoShutsuryokuYMD();
    }

    /**
     * 調査票等出力年月日を返します。
     *
     * @return 調査票等出力年月日
     */
    public FlexibleDate get調査票等出力年月日() {
        return entity.getChosahyoTouShutsuryokuYMD();
    }

    /**
     * 認定調査期限年月日を返します。
     *
     * @return 認定調査期限年月日
     */
    public FlexibleDate get認定調査期限年月日() {
        return entity.getNinteichosaKigenYMD();
    }

    /**
     * 認定調査依頼区分コーを返します。
     *
     * @return 認定調査依頼区分コード
     */
    public Code get認定調査依頼区分コード() {
        return entity.getNinteichosaIraiKubunCode();
    }

    /**
     * 認定調査督促年月日を返します。
     *
     * @return 認定調査督促年月日
     */
    public FlexibleDate get認定調査督促年月日() {
        return entity.getNinteichosaKigenYMD();
    }

    /**
     * 認定調査督促方法を返します。
     *
     * @return 認定調査督促方法
     */
    public RString get認定調査督促方法() {
        return entity.getNinteichosaTokusokuHoho();
    }

    /**
     * 認定調査督促回数を返します。
     *
     * @return 認定調査督促回数
     */
    public int get認定調査督促回数() {
        return entity.getNinteichosaTokusokuKaisu();
    }

    /**
     * 今回調査調査回数を返します。
     *
     * @return 今回調査調査回数
     */
    public int get今回調査調査回数() {
        return entity.getNinteichosaIraiKaisu();
    }

    /**
     * 今回調査委託先を返します。
     *
     * @return 今回調査委託先
     */
    public RString get今回調査委託先() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 今回調査員氏名を返します。
     *
     * @return 今回調査員氏名
     */
    public RString get今回調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 前回調査委託先を返します。
     *
     * @return 前回調査委託先
     */
    public RString get前回調査委託先() {
        return entity.getBefore_jigyoshaMeisho();
    }

    /**
     * 前回調査員氏名を返します。
     *
     * @return 前回調査員氏名
     */
    public RString get前回調査員氏名() {
        return entity.getBefore_chosainShimei();
    }

    /**
     * 前前回調査委託先を返します。
     *
     * @return 前前回調査委託先
     */
    public RString get前前回調査委託先() {
        return entity.getBefore_before_jigyoshaMeisho();
    }

    /**
     * 前前回調査員氏名を返します。
     *
     * @return 前前回調査員氏名
     */
    public RString get前前回調査員氏名() {
        return entity.getBefore_before_chosainShimei();
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public RString get地区コード() {
        return entity.getChikuCode();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaIraiRirekiNo();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }
}
