/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.shujiijoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.shujiijoho.ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiijoho.ShujiiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.basic.shujiijoho.ShujiiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.shujiijoho.IShujiiJohoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5912ShujiiJohoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタを管理するクラスです。
 */
public class ShujiiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5912ShujiiJohoDac 主治医情報Dac;

    /**
     * コンストラクタです。
     */
    ShujiiJohoManager() {
	this.mapperProvider = InstanceProvider.create(MapperProvider.class);
	this.主治医情報Dac = InstanceProvider.create(DbT5912ShujiiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5912ShujiiJohoDac}
     */
    ShujiiJohoManager(DbT5912ShujiiJohoDac 主治医情報Dac, MapperProvider mapperProvider) {
	this.主治医情報Dac = 主治医情報Dac;
	this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiJohoManager}のインスタンス
     */
    public static ShujiiJohoManager createInstance() {
	return InstanceProvider.create(ShujiiJohoManager.class);
    }

    /**
     * 主治医情報を返します。
     *
     * @param 主治医情報検索条件 主治医情報検索条件
     *
     * @return ShujiiJohoList
     */
    @Transaction
    public List<ShujiiJoho> get主治医情報(ShujiiJohoMapperParameter 主治医情報検索条件) {
	requireNonNull(主治医情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医情報検索条件"));
	List<ShujiiJoho> list = new ArrayList<>();
	IShujiiJohoMapper mapper = mapperProvider.create(IShujiiJohoMapper.class);
	List<ShujiiJohoRelateEntity> shujiiJohoList = mapper.getShujiiJohoEntity(主治医情報検索条件);
	if (shujiiJohoList == null || shujiiJohoList.isEmpty()) {
	    return new ArrayList();
	}
	for (ShujiiJohoRelateEntity entity : shujiiJohoList) {
	    list.add(new ShujiiJoho(entity));
	}
	return list;

    }

    /**
     * 主治医情報の挿入します。
     *
     * @param entity
     *
     * @return ShujiiJohoList
     */
    @Transaction
    public int insert主治医情報(DbT5912ShujiiJohoEntity entity) {
	requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("entity"));
	int count = 主治医情報Dac.save(entity);
	return count;
    }

    /**
     * 主治医情報の更新します。
     *
     * @param entity
     *
     * @return ShujiiJohoList
     */
    @Transaction
    public int update主治医情報(DbT5912ShujiiJohoEntity entity) {
	requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("entity"));
	int count = 主治医情報Dac.save(entity);
	return count;
    }

    /**
     * 主治医情報を返します。
     *
     * @param parameter
     *
     * @return ShujiiJohoList
     */
    @Transaction
    public int delete主治医情報(ShujiiJohoMapperParameter parameter) {
	requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
	IShujiiJohoMapper mapper = mapperProvider.create(IShujiiJohoMapper.class);
	int ninteiShinseiJohoCount = mapper.getNinteiShinseiJohoCount(parameter);
	int shujiiIkenshoIraiJohoCount = mapper.getShujiiIkenshoIraiJohoCount(parameter);
	if (ninteiShinseiJohoCount > 0 || shujiiIkenshoIraiJohoCount > 0) {
	    //throw new exception(); // TODO
	}
	DbT5912ShujiiJohoEntity dbT5912ShujiiJohoEntity = new DbT5912ShujiiJohoEntity();
//	dbT5912ShujiiJohoEntity.setShichosonCode(parameter.getShichosonCode());
//	dbT5912ShujiiJohoEntity.setShujiiIryokikanCode(parameter.getShujiiIryokikanCodeFrom());
//	dbT5912ShujiiJohoEntity.setShujiiCode(parameter.getShujiiCodeFrom());
	int shujiiJohoEntity = 主治医情報Dac.save(dbT5912ShujiiJohoEntity);

	if (shujiiJohoEntity == 0) {
	    //TODO
	}
	return shujiiJohoEntity;

    }

}
