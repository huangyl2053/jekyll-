/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic.KojinJokyoShokai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.definition.parameter.KojinJokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.relate.KojinJokyoShokai.KojinJokyoShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.KojinJokyoShokai.KojinJokyoShokaiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author soft863
 */
public class KojinJokyoShokaiManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KojinJokyoShokaiManager() {
	this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5912ShujiiJohoDac}
     */
    KojinJokyoShokaiManager(MapperProvider mapperProvider) {
	this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiJohoManager}のインスタンス
     */
    public static KojinJokyoShokaiManager createInstance() {
	return InstanceProvider.create(KojinJokyoShokaiManager.class);
    }

    /**
     * 主治医情報を返します。
     *
     *
     * @param parameter
     * @return kojinJokyoShokaiRelateEntity
     */
    @Transaction
    public KojinJokyoShokaiRelateEntity get要介護認定個人状況照会(KojinJokyoShokaiParameter parameter) {
	requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
	KojinJokyoShokaiMapper mapper = mapperProvider.create(KojinJokyoShokaiMapper.class);
	KojinJokyoShokaiRelateEntity kojinJokyoShokaiRelateEntity = mapper.getKojinJokyoShokaiRelateEntity(parameter);

	if (kojinJokyoShokaiRelateEntity == null) {
	    return null;
	}

	return kojinJokyoShokaiRelateEntity;
    }

}
