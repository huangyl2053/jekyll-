/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic.ninteichosascheduleinput;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosascheduleinput.NinteiChosaScheduleRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査員情報のクラスです。
 */
public class NinteiChosaSchedule {

    private final NinteiChosaScheduleRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link NinteiChosaScheduleRelateEntity}より{@link NinteiChosaSchedule}を生成します。
     *
     * @param entity DBより取得した{@link NinteiChosaScheduleRelateEntity}
     */
    public NinteiChosaSchedule(NinteiChosaScheduleRelateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("申請履歴情報"));
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public Code get地区コード() {
        return entity.getChosaChikuCode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
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
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 設定日を返します。
     *
     * @return 設定日
     */
    public FlexibleDate get設定日() {
        return entity.getNinteiChosaYoteiYMD();
    }

    /**
     * 認定調査予定開始時間を返します。
     *
     * @return 認定調査予定開始時間
     */
    public RString get認定調査予定開始時間() {
        return entity.getNinteiChosaYoteiKaishiTime();
    }

    /**
     * 認定調査予定終了時間を返します。
     *
     * @return 認定調査予定終了時間
     */
    public RString get認定調査予定終了時間() {
        return entity.getNinteiChosaYoteiShuryoTime();
    }

    /**
     * 時間枠を返します。
     *
     * @return 時間枠
     */
    public RString get時間枠() {
        return entity.getNinteiChosaJikanWaku();
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
     * 予約可否を返します。
     *
     * @return 予約可否
     */
    public boolean is予約可否() {
        return entity.isYoyakuKaoFlag();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * 認定調査委託先名称を返します。
     *
     * @return 認定調査委託先名称
     */
    public RString get認定調査委託先名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 認定調査員名称を返します。
     *
     * @return 認定調査員名称
     */
    public RString get認定調査員名称() {
        return entity.getChosainShimei();
    }
}
