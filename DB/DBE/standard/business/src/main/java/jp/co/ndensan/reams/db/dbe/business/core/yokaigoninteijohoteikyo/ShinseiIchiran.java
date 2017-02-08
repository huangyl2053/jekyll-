/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.ShinseiIchiranEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請一覧クラスです。
 *
 * @author N3212 竹内 和紀
 */
public class ShinseiIchiran {

    private final ShinseiIchiranEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity ShinseiIchiranEntity
     */
    public ShinseiIchiran(ShinseiIchiranEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 保険者名称を返します。
     *
     * @return 保険者名称
     */
    public RString get保険者名称() {
        return entity.get保険者名称();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    public int get年齢() {
        return entity.get年齢();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.get認定申請年月日();
    }

    /**
     * 申請区分を返します。
     *
     * @return 申請区分
     */
    public RString get申請区分() {
        return entity.get申請区分();
    }

    /**
     * 二次判定結果を返します。
     *
     * @return 二次判定結果
     */
    public RString get二次判定結果() {
        return entity.get二次判定結果();
    }

    /**
     * 開催予定日を返します。
     *
     * @return 開催予定日
     */
    public FlexibleDate get開催予定日() {
        return entity.get開催予定日();
    }

    /**
     * 開催日を返します。
     *
     * @return 開催日
     */
    public FlexibleDate get開催日() {
        return entity.get開催日();
    }

    /**
     * 被保険者の同意を返します。
     *
     * @return 被保険者の同意
     */
    public boolean get被保険者の同意() {
        return entity.is被保険者の同意();
    }

    /**
     * 主治医の同意を返します。
     *
     * @return 主治医の同意
     */
    public boolean get主治医の同意() {
        return entity.is主治医の同意();
    }

    /**
     * 情報提供資料出力年月日を返します。
     *
     * @return 情報提供資料出力年月日
     */
    public FlexibleDate get情報提供資料出力年月日() {
        return entity.get情報提供資料出力年月日();
    }

    /**
     * 認定審査会完了年月日を返します。
     *
     * @return 認定審査会完了年月日
     */
    public FlexibleDate get認定審査会完了年月日() {
        return entity.get認定審査会完了年月日();
    }
}
