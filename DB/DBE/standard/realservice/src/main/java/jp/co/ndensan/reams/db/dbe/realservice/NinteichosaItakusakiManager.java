/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.HatsubanJoho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5020HatsubanKanriJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.HatsubanJohoMapper;
import jp.co.ndensan.reams.db.dbe.business.mapper.NinteichosaItakusakiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.IHatsubanKanriJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.NinteichosaItakusakiDac;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査委託先の情報を管理するクラスです
 *
 * @author N1013 松本直樹
 */
public class NinteichosaItakusakiManager {

    private final NinteichosaItakusakiDac dac;
    private final IHatsubanKanriJohoDac hatsubanDac;

    /**
     * コンストラクタクラスです
     *
     */
    public NinteichosaItakusakiManager() {
        dac = InstanceProvider.create(NinteichosaItakusakiDac.class);
        hatsubanDac = InstanceProvider.create(IHatsubanKanriJohoDac.class);
    }

    /**
     * テスト用のコンストラクタです。
     *
     */
    NinteichosaItakusakiManager(NinteichosaItakusakiDac dac, IHatsubanKanriJohoDac hatsubanDac) {
        this.dac = dac;
        this.hatsubanDac = hatsubanDac;
    }

    /**
     * 市町村コードと介護事業状況を指定して該当する調査委託先を全件取得するクラスです
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業状況 介護事業状況
     * @return NinteichosaItakusaki
     */
    public List<NinteichosaItakusaki> get認定調査委託先市町村指定全件(LasdecCode 市町村コード, Boolean 介護事業状況) {
        List<NinteichosaItakusaki> list = new ArrayList();
        List<DbT7010NinteichosaItakusakiJohoEntity> entityList = dac.selectAll(市町村コード, 介護事業状況);

        if (entityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        for (DbT7010NinteichosaItakusakiJohoEntity entity : entityList) {
            NinteichosaItakusaki ninteichosaItakusaki = NinteichosaItakusakiMapper.toNinteichosaItakusaki(entity);
            list.add(ninteichosaItakusaki);
        }

        return list;
    }

    /**
     * 市町村コードを指定して該当する調査委託先を全件取得するクラスです
     *
     * @param 市町村コード 市町村コード
     * @return NinteichosaItakusaki
     */
    public List<NinteichosaItakusaki> get認定調査委託先市町村指定全件(LasdecCode 市町村コード) {
        List<NinteichosaItakusaki> list = new ArrayList();
        List<DbT7010NinteichosaItakusakiJohoEntity> entityList = dac.selectAll(市町村コード);

        if (entityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        for (DbT7010NinteichosaItakusakiJohoEntity entity : entityList) {
            NinteichosaItakusaki ninteichosaItakusaki = NinteichosaItakusakiMapper.toNinteichosaItakusaki(entity);
            list.add(ninteichosaItakusaki);
        }

        return list;
    }

    /**
     * 証記載保険者番号・介護事業者番号・介護事業区分を指定し、認定調査委託先を取得するクラスです
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護事業状況 介護事業状況
     * @return NinteichosaItakusaki
     */
    public NinteichosaItakusaki get認定調査委託先介護事業者番号指定(LasdecCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, boolean 介護事業状況) {
        DbT7010NinteichosaItakusakiJohoEntity entity = dac.select(市町村コード, 介護事業者番号, 介護事業状況);

        if (entity == null) {
            return null;
        }

        return NinteichosaItakusakiMapper.toNinteichosaItakusaki(entity);
    }

    /**
     * 市町村コード・事業者番号・介護事業区分を指定し、認定調査委託先を取得するクラスです
     *
     * @param 市町村コード 市町村コード
     * @param 事業者番号 事業者番号
     * @param 介護事業状況 介護事業状況
     * @return NinteichosaItakusaki
     */
    public NinteichosaItakusaki get認定調査委託先事業者番号指定(LasdecCode 市町村コード, JigyoshaNo 事業者番号, boolean 介護事業状況) {
        DbT7010NinteichosaItakusakiJohoEntity entity = dac.select(市町村コード, 事業者番号, 介護事業状況);

        if (entity == null) {
            return null;
        }

        return NinteichosaItakusakiMapper.toNinteichosaItakusaki(entity);
    }

    /**
     * 調査委託先を追加・更新します
     *
     * @param ninteichosaitakusaki 認定調査委託先
     * @return 追加・更新結果
     */
    public int save(NinteichosaItakusaki ninteichosaitakusaki) {
        int result = dac.insertOrUpdate(NinteichosaItakusakiMapper.toNinteichosaItakusakiEntity(ninteichosaitakusaki));
        if (result != 1) {
            throw new ApplicationException(Messages.E00003.replace("認定調査委託先の更新").getMessage());
        }
        return result;
    }

    /**
     * 項目区分、年度を指定し発番情報を取得します
     *
     * @param 項目区分 項目区分
     * @param 年度 年度
     * @return 発番情報
     */
    public HatsubanJoho get発番情報(RString 項目区分, RString 年度) {
        DbT5020HatsubanKanriJohoEntity entity = hatsubanDac.select(項目区分, 年度);

        if (entity == null) {
            return null;
        }

        return HatsubanJohoMapper.toHatsubanJoho(entity);
    }

    /**
     * 発番管理情報を更新します
     *
     * @param 項目区分 項目区分
     * @param 発番情報 発番情報
     * @return 更新結果
     */
    public int updateHatsubanJoho(RString 項目区分, HatsubanJoho 発番情報) {
        DbT5020HatsubanKanriJohoEntity entity = new DbT5020HatsubanKanriJohoEntity(項目区分, new RString("0000"), 発番情報.getColumnValue());
        return hatsubanDac.update(entity);
    }
}
