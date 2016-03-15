/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.shinsakaijohokojin;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin.WariateIinAndIinJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 審査会委員情報のbusinessクラスです。
 */
public class WariateIinAndIinJoho {

    private final WariateIinAndIinJohoEntity entity;

    /**
     * <p>
     * コンストラクタです。
     * </p>
     * <p>
     * DBより取得した{@link WariateIinAndIinJohoEntity}より{@link WariateIinAndIinJoho}を生成します。
     * </p>
     *
     * @param entity DBより取得した{@link WariateIinAndIinJohoEntity}
     */
    public WariateIinAndIinJoho(WariateIinAndIinJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員情報"));
    }

    /**
     * 審査会委員情報を返します。
     *
     * @return 審査会委員情報
     */
    public WariateIinAndIinJohoEntity get審査会委員情報() {
        return entity;
    }

    /**
     * 介護認定審査会議長区分コードを返します。
     *
     * @return 介護認定審査会議長区分コード
     */
    public Code get介護認定審査会議長区分コード() {
        return entity.get介護認定審査会議長区分コード();
    }

    /**
     * 介護認定審査会委員コードを返します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString get介護認定審査会委員コード() {
        return entity.get介護認定審査会委員コード();
    }

    /**
     * 介護認定審査会委員氏名を返します。
     *
     * @return 介護認定審査会委員氏名
     */
    public AtenaMeisho get介護認定審査会委員氏名() {
        return entity.get介護認定審査会委員氏名();
    }

    /**
     * 介護認定審査員資格コードを返します。
     *
     * @return 介護認定審査員資格コード
     */
    public Code get介護認定審査員資格コード() {
        return entity.get介護認定審査員資格コード();
    }
}
