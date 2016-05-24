/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.seikatsuhogorireki;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.seikatsuhogorireki.SeikatsuhogoRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 生活保護履歴情報のBusinessクラスです。
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
public class SeikaatsuhogoBusiness {

    private final SeikatsuhogoRelateEntity relateEntity;

    /**
     * コンストラクタです。
     *
     * @param relateEntity SeikatsuhogoRelateEntity
     */
    public SeikaatsuhogoBusiness(SeikatsuhogoRelateEntity relateEntity) {
        this.relateEntity = requireNonNull(relateEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護履歴情報"));
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return relateEntity.getShikibetsuCode();
    }

    /**
     * 業務コードを取得します。
     *
     * @return 業務コード
     */
    public GyomuCode get業務コード() {
        return relateEntity.getGyomuCode();
    }

    /**
     * 受給開始日を取得します。
     *
     * @return 受給開始日
     */
    public FlexibleDate get受給開始日() {
        return relateEntity.getJukyuKaishiYMD();
    }

    /**
     * 受給廃止日を取得します。
     *
     * @return 受給廃止日
     */
    public FlexibleDate get受給廃止日() {
        return relateEntity.getJukyuHaishiYMD();
    }

    /**
     * 受給者番号を取得します。
     *
     * @return 受給者番号
     */
    public RString get受給者番号() {
        return relateEntity.getJukyushaNo();
    }

    /**
     * 介護保険料代理納付区分を取得します。
     *
     * @return 介護保険料代理納付区分
     */
    public RString get納付区分() {
        return relateEntity.getKaigoRyoDairiNofuKubun();
    }

    /**
     * 介護保険料代理納付年月を取得します。
     *
     * @return 介護保険料代理納付年月
     */
    public FlexibleYearMonth get納付年月() {
        return relateEntity.getKaigoRyoDairiNofuYM();
    }

    /**
     * 入退所区分を取得します。
     *
     * @return 入退所区分
     */
    public RString get入退所区分() {
        return relateEntity.getKyugoShisetsuNyuTaishoKubun();
    }

    /**
     * 救護施設入退所日を取得します。
     *
     * @return 救護施設入退所日
     */
    public FlexibleDate get入退所日() {
        return relateEntity.getKyugoShisetsuNyutaishoYMD();
    }

    /**
     * 受給停止開始日を取得します。
     *
     * @return 受給停止開始日
     */
    public RString get受給停止開始日() {
        return relateEntity.getJukyuTeishiKaishiYMD();
    }

    /**
     * 受給停止終了日を取得します。
     *
     * @return 受給停止終了日
     */
    public RString get受給停止終了日() {
        return relateEntity.getJukyuTeishiShuryoYMD();
    }

    /**
     * 扶助種類コードを取得します。
     *
     * @return 扶助種類コード
     */
    public RString get扶助種類コード() {
        return relateEntity.getFujoShuruiCode();
    }

    /**
     * 扶助種類を取得します。
     *
     * @return 扶助種類
     */
    public RString get扶助種類() {
        return relateEntity.getFujoShurui();
    }
}
