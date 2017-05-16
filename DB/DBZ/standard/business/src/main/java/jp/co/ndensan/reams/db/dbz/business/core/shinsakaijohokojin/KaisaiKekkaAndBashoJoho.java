/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shinsakaijohokojin;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin.KaisaiKekkaAndBashoJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 開催結果情報と開催場所情報のbusinessクラスです。
 *
 * @reamsid_L DBE-3000-070 zhengshukai
 */
public class KaisaiKekkaAndBashoJoho {

    private final KaisaiKekkaAndBashoJohoEntity entity;

    /**
     * <p>
     * コンストラクタです。
     * </p>
     * <p>
     * DBより取得した{@link KaisaiKekkaAndBashoJohoEntity}より{@link KaisaiKekkaAndBashoJoho}を生成します。
     * </p>
     *
     * @param entity DBより取得した{@link KaisaiKekkaAndBashoJohoEntity}
     */
    public KaisaiKekkaAndBashoJoho(KaisaiKekkaAndBashoJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("開催結果情報と開催場所情報"));
    }

    /**
     * 開催結果情報と開催場所情報を返します。
     *
     * @return 開催結果情報と開催場所情報
     */
    public KaisaiKekkaAndBashoJohoEntity get開催結果情報と開催場所情報() {
        return entity;
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return entity.get介護認定審査会開催番号();
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.get合議体番号();
    }

    /**
     * 合議体名称を返します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.get合議体名称();
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
     * 介護認定審査会開催年月日を返します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.get介護認定審査会開催年月日();
    }

    /**
     * 介護認定審査会開始時刻を返します。
     *
     * @return 介護認定審査会開始時刻
     */
    public RString get介護認定審査会開始時刻() {
        return entity.is開催済み()
                ? entity.get介護認定審査会開始時刻()
                : entity.get開始予定時刻();
    }

    /**
     * 介護認定審査会終了時刻を返します。
     *
     * @return 介護認定審査会終了時刻
     */
    public RString get介護認定審査会終了時刻() {
        return entity.is開催済み()
                ? entity.get介護認定審査会終了時刻()
                : entity.get終了予定時刻();
    }

    /**
     * 所要時間合計を返します。
     *
     * @return 所要時間合計
     */
    public int get所要時間合計() {
        return entity.get所要時間合計();
    }

    /**
     * 介護認定審査会開催場所名称を返します。
     *
     * @return 介護認定審査会開催場所名称
     */
    public RString get介護認定審査会開催場所名称() {
        return entity.is開催済み()
                ? entity.get介護認定審査会開催場所名称()
                : entity.get開催予定場所名();
    }

    /**
     * 介護認定審査会開催地区コードを返します。
     *
     * @return 介護認定審査会開催地区コード
     */
    public Code get介護認定審査会開催地区コード() {
        return entity.is開催済み()
                ? entity.get介護認定審査会開催地区コード()
                : entity.get開催予定地区コード();
    }

    /**
     * @return 判定結果の名称
     */
    public RString get判定結果名() {
        if (HanteiKekkaCode.existsCode(entity.get判定結果コード())) {
            return HanteiKekkaCode.toValue(entity.get判定結果コード()).get名称();
        }
        return RString.EMPTY;
    }

    /**
     * @return 審査会意見
     */
    public RString get審査会意見() {
        return entity.get審査会意見();
    }

}
