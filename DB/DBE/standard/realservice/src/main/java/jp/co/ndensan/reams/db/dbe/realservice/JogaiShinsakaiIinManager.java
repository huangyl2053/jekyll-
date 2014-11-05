/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5014ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.JogaiShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.JogaiShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiIinJogaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.JogaiShinsakaiIinDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 除外対象の審査会委員情報を管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class JogaiShinsakaiIinManager {

    private final JogaiShinsakaiIinDac jogaiShinsakaiIinDac;
    private final ShinsakaiIinJogaiJohoDac shinsakaiIinJogaiJohoDac;

    /**
     * デフォルトコンストラクタです。
     */
    public JogaiShinsakaiIinManager() {
        jogaiShinsakaiIinDac = InstanceProvider.create(JogaiShinsakaiIinDac.class);
        shinsakaiIinJogaiJohoDac = InstanceProvider.create(ShinsakaiIinJogaiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param jogaiShinsakaiIinDacMock 除外審査会委員Dac
     * @param shinsakaiIinJogaiJohoDacMock 審査会委員除外情報Dac
     */
    JogaiShinsakaiIinManager(JogaiShinsakaiIinDac jogaiShinsakaiIinDacMock, ShinsakaiIinJogaiJohoDac shinsakaiIinJogaiJohoDacMock) {
        this.jogaiShinsakaiIinDac = jogaiShinsakaiIinDacMock;
        this.shinsakaiIinJogaiJohoDac = shinsakaiIinJogaiJohoDacMock;
    }

    /**
     * 証記載保険者番号と被保険者番号を指定して、一人の申請者に対応する除外対象審査会委員情報をListで取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @return 除外対象審査会委員List
     */
    public JogaiShinsakaiIinList get除外審査会委員List(ShoKisaiHokenshaNo 証記載保険者番号, KaigoHihokenshaNo 被保険者番号) {
        List<JogaiShinsakaiIinEntity> entities = jogaiShinsakaiIinDac.select(証記載保険者番号, 被保険者番号);
        return JogaiShinsakaiIinMapper.toJogaiShinsakaiIinList(entities);
    }

    /**
     * 除外審査会委員の情報を保存します。
     *
     * @param 除外対象審査会委員 除外対象審査会委員
     * @return 保存成功ならtrue
     */
    public boolean save(JogaiShinsakaiIin 除外対象審査会委員) {
        DbT5014ShinsakaiIinJogaiJohoEntity entity = JogaiShinsakaiIinMapper.toShinsakaiIinJogaiJohoEntity(除外対象審査会委員);
        return shinsakaiIinJogaiJohoDac.insertOrUpdate(entity) != 0;
    }

    /**
     * 除外審査会委員の情報を削除します。
     *
     * @param 除外対象審査会委員 除外対象審査会委員
     * @return 削除成功ならtrue
     */
    public boolean remove(JogaiShinsakaiIin 除外対象審査会委員) {
        DbT5014ShinsakaiIinJogaiJohoEntity entity = JogaiShinsakaiIinMapper.toShinsakaiIinJogaiJohoEntity(除外対象審査会委員);
        return shinsakaiIinJogaiJohoDac.delete(entity) != 0;
    }
}
