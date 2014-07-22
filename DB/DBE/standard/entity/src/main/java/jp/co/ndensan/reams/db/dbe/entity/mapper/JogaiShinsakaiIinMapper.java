/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5014ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.JogaiShinsakaiIinEntity;

/**
 * 除外対象審査会委員のマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class JogaiShinsakaiIinMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private JogaiShinsakaiIinMapper() {
    }

    /**
     * 審査会委員とその除外情報を受け取り、その情報を元に除外審査会委員クラスにマッピングして返します。
     *
     * @param 除外対象委員Entity 除外対象委員Entity
     * @return 除外審査会委員
     */
    public static JogaiShinsakaiIin toJogaiShinsakaiIin(JogaiShinsakaiIinEntity 除外対象委員Entity) {
        if (除外対象委員Entity == null) {
            return null;
        }

        DbT5102ShinsakaiIinJohoEntity 審査会委員Entity = 除外対象委員Entity.get審査会委員Entity();
        DbT5014ShinsakaiIinJogaiJohoEntity 審査会委員除外情報Entity = 除外対象委員Entity.get除外委員情報Entity();
        if (審査会委員Entity == null || 審査会委員除外情報Entity == null) {
            return null;
        }

        return new JogaiShinsakaiIin(審査会委員除外情報Entity.getShoKisaiHokenshaNo(),
                審査会委員除外情報Entity.getHihokenshaNo(),
                審査会委員除外情報Entity.getKanriNo(),
                ShinsakaiIinMapper.to審査会委員(審査会委員Entity));
    }

    /**
     * 除外対象審査会委員Entityのリストを受け取り、除外審査会委員Listにマッピングして返します。
     *
     * @param 除外対象委員EntityList 除外対象委員EntityList
     * @return 除外審査会委員List
     */
    public static JogaiShinsakaiIinList toJogaiShinsakaiIinList(List<JogaiShinsakaiIinEntity> 除外対象委員EntityList) {
        if (除外対象委員EntityList == null) {
            return new JogaiShinsakaiIinList(Collections.EMPTY_LIST);
        }

        List<JogaiShinsakaiIin> list = new ArrayList<>();
        for (JogaiShinsakaiIinEntity 除外対象委員Entity : 除外対象委員EntityList) {
            list.add(toJogaiShinsakaiIin(除外対象委員Entity));
        }
        return new JogaiShinsakaiIinList(list);
    }

    /**
     * 除外対象委員の情報を、審査会委員除外情報Entityにマッピングします。nullが渡された場合、nullを返します。
     *
     * @param 除外対象委員 除外対象委員
     * @return 審査会委員除外情報Entity
     */
    public static DbT5014ShinsakaiIinJogaiJohoEntity toShinsakaiIinJogaiJohoEntity(JogaiShinsakaiIin 除外対象委員) {
        if (除外対象委員 == null) {
            return null;
        }
        DbT5014ShinsakaiIinJogaiJohoEntity entity = new DbT5014ShinsakaiIinJogaiJohoEntity();
        entity.setShoKisaiHokenshaNo(除外対象委員.get証記載被保険者番号());
        entity.setHihokenshaNo(除外対象委員.get被保険者番号());
        entity.setKanriNo(除外対象委員.get管理番号());
        entity.setJogaiTaishoShinsakaiIinCode(除外対象委員.get除外対象審査会委員().get審査会委員コード().value());
        return entity;
    }

    /**
     * 除外対象委員のリストを受け取り、審査会委員除外情報Entityのリストにマッピングして返します。<br/>
     * 引数にnullが渡された場合は空のリストを返します。
     *
     * @param 除外対象委員List 除外対象委員List
     * @return 審査会委員除外情報Entityのリスト
     */
    public static List<DbT5014ShinsakaiIinJogaiJohoEntity> toShinsakaiIinJogaiJohoEntityList(JogaiShinsakaiIinList 除外対象委員List) {
        if (除外対象委員List == null) {
            return Collections.EMPTY_LIST;
        }

        List<DbT5014ShinsakaiIinJogaiJohoEntity> list = new ArrayList<>();
        for (JogaiShinsakaiIin 除外対象委員 : 除外対象委員List) {
            list.add(toShinsakaiIinJogaiJohoEntity(除外対象委員));
        }
        return list;
    }
}
