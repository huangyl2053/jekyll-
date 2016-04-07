/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain.ChikuNinteiKoseiShichosonRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者名情報を管理するクラスです。
 *
 * @reamsid_L DBE-0020-020 lishengli
 */
public class ChikuNinteiKoseiShichoson {

    private final ChikuNinteiKoseiShichosonRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChikuNinteiKoseiShichosonRelateEntity}より{@link ChikuNinteiKoseiShichoson}を生成します。
     *
     * @param entity DBより取得した{@link ChikuNinteiKoseiShichosonRelateEntity}
     */
    public ChikuNinteiKoseiShichoson(ChikuNinteiKoseiShichosonRelateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("対象地区"));
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
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }
}
