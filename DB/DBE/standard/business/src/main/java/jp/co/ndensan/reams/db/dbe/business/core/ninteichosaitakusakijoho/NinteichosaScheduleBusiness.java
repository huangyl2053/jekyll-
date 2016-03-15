/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.NinteichosaScheduleRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査スケジュール登録9Businessです。
 */
public class NinteichosaScheduleBusiness {

    private final NinteichosaScheduleRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChikuShichosonRelateEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link NinteiChosainMasterRelateEntity}
     */
    public NinteichosaScheduleBusiness(NinteichosaScheduleRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 事務所名を返します。
     *
     * @return 事務所名
     */
    public RString get事務所名() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 認定調査予約日を返します。
     *
     * @return 認定調査予約日
     */
    public FlexibleDate get認定調査予約日() {
        return entity.getNinteiChosaYoteiYMD();
    }

    /**
     * 認定調査予定開始時間を返します。
     *
     * @return 認定調査予約日
     */
    public RString get認定調査予定開始時間() {
        return entity.getNinteiChosaYoteiKaishiTime();
    }

    /**
     * 認定調査予定終了時間を返します。
     *
     * @return 認定調査予約日
     */
    public RString get認定調査予定終了時間() {
        return entity.getNinteiChosaYoteiShuryoTime();
    }

    /**
     * 予約状況を返します。
     *
     * @return 予約状況
     */
    public Code get予約状況() {
        return entity.getYoyakuJokyo();
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
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 被保険者住所を返します。
     *
     * @return 被保険者住所
     */
    public AtenaJusho get被保険者住所() {
        return entity.getJusho();
    }

    /**
     * 場所を返します。
     *
     * @return 場所
     */
    public RString get場所() {
        return entity.getBasho();
    }

    /**
     * 立会者1を返します。
     *
     * @return 立会者1
     */
    public RString get立会者1() {
        return entity.getTachiainin1();
    }

    /**
     * 立会者2を返します。
     *
     * @return 立会者2
     */
    public RString get立会者2() {
        return entity.getTachiainin2();
    }

    /**
     * 連絡先１を返します。
     *
     * @return 連絡先１
     */
    public TelNo get連絡先１() {
        return entity.getRenrakusaki1();
    }

    /**
     * 連絡先2を返します。
     *
     * @return 連絡先2
     */
    public TelNo get連絡先2() {
        return entity.getRenrakusaki2();
    }

    /**
     * 対象者メモを返します。
     *
     * @return 対象者メモ
     */
    public RString get対象者メモ() {
        return entity.getTaishoshaMemo();
    }
}
