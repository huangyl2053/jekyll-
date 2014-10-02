/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.IShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 主治医医療機関のマッパーです。
 *
 * @author n8178 城間篤人
 */
public final class ShujiiIryoKikanMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShujiiIryoKikanMapper() {
    }

    /**
     * 引数から渡されたエンティティを、主治医医療機関クラスにマッピングして返します。
     *
     * @param shujiiIryokikanEntity 主治医医療機関エンティティ
     * @return 主治医医療機関
     * @throws NullPointerException 引数にNULLが渡された場合
     */
    public static IShujiiIryoKikan toShujiiIryoKikan(DbT7011ShujiiIryoKikanJohoEntity shujiiIryokikanEntity) throws NullPointerException {
        requireNonNull(shujiiIryokikanEntity, Messages.E00003.replace("主治医医療機関エンティティ", "主治医医療機関").getMessage());

        return new ShujiiIryoKikan(shujiiIryokikanEntity.getShichosonCode(),
                shujiiIryokikanEntity.getKaigoIryokikanCode(),
                create医療機関コード(shujiiIryokikanEntity),
                IryoKikanJokyo.toValue(shujiiIryokikanEntity.getIryokikanJokyo()),
                create医療機関区分(shujiiIryokikanEntity));
    }

    private static IIryoKikanCode create医療機関コード(DbT7011ShujiiIryoKikanJohoEntity entity) {
        return new _IryoKikanCode(entity.getIryokikanCode());
    }

    private static IryoKikanKubun create医療機関区分(DbT7011ShujiiIryoKikanJohoEntity entity) {
        return new IryoKikanKubun(entity.getKikanKubunCode(), entity.getKikanKubunCodeMeisho(), entity.getKikanKubunCodeRyakusho());
    }

    /**
     * 引数に主治医医療機関クラスを渡し、エンティティにマッピングして返します。
     *
     * @param iryoKikan 主治医医療機関クラス
     * @return 主治医医療機関エンティティ
     * @throws NullPointerException 引数にNULLが渡された場合
     */
    public static DbT7011ShujiiIryoKikanJohoEntity toShujiiIryoKikanEntity(IShujiiIryoKikan iryoKikan) throws NullPointerException {

        requireNonNull(iryoKikan, Messages.E00003.replace("主治医医療機関", "主治医医療機関エンティティ").getMessage());

        //TODO n8178 城間篤人 共通項目についてどのように扱うか未定 2014年2月末
        DbT7011ShujiiIryoKikanJohoEntity entity = new DbT7011ShujiiIryoKikanJohoEntity();

        entity.setShichosonCode(iryoKikan.get市町村コード());
        entity.setKaigoIryokikanCode(iryoKikan.get介護医療機関コード());
        //TODO n8178 城間篤人 IDbColumnMappableじゃないが、共通の医療機関テーブルが確定するまでは、扱いを保留にする 2014年2月末
        entity.setIryokikanCode(iryoKikan.get医療機関コード().getValue());
        entity.setIryokikanJokyo(iryoKikan.is有効());
        entity.setKikanKubunCode(iryoKikan.get医療機関区分().getCode());
        return entity;
    }

    /**
     * 引数に主治医医療機関クラスと医療機関状況を指定し、それらの情報を元にエンティティにマッピングして返します。
     *
     * @param iryoKikan 主治医医療機関クラス
     * @param 医療機関状況 医療機関状況
     * @return 主治医医療機関エンティティ
     * @throws NullPointerException 引数にNULLが渡された場合
     */
    public static DbT7011ShujiiIryoKikanJohoEntity toShujiiIryoKikanEntity(IShujiiIryoKikan iryoKikan, IryoKikanJokyo 医療機関状況)
            throws NullPointerException {

        requireNonNull(iryoKikan, Messages.E00003.replace("主治医医療機関", "主治医医療機関エンティティ").getMessage());
        requireNonNull(iryoKikan, Messages.E00003.replace("医療機関状況", "主治医医療機関エンティティ").getMessage());

        DbT7011ShujiiIryoKikanJohoEntity entity = toShujiiIryoKikanEntity(iryoKikan);
        entity.setIryokikanJokyo(医療機関状況.is有効());
        return entity;
    }
}
