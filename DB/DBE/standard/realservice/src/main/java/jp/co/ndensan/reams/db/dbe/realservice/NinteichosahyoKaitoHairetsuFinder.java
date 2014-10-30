/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.NinteichosahyoKaitoHairetsuCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.NinteichosahyoKaitoHairetsuCodeMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.NinteichosahyoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査票の情報を、一次判定で使用できる形で取得するFinderです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosahyoKaitoHairetsuFinder {

    private final NinteichosahyoDac dac;

    /**
     * デフォルトコンストラクタです。
     */
    public NinteichosahyoKaitoHairetsuFinder() {
        dac = InstanceProvider.create(NinteichosahyoDac.class);
    }

    /**
     * 外部からDacを受け取る、テスト用コンストラクタです。
     *
     * @param dac テスト用Dac
     */
    NinteichosahyoKaitoHairetsuFinder(NinteichosahyoDac dac) {
        this.dac = dac;
    }

    /**
     * 申請書管理番号を指定して、一次判定の計算で使用できる形で認定調査票回答結果を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査票回答結果
     */
    public NinteichosahyoKaitoHairetsuCode get認定調査票回答結果(ShinseishoKanriNo 申請書管理番号) {
        DbT5009NinteichosahyoJohoEntity entity = dac.select(申請書管理番号);
        return NinteichosahyoKaitoHairetsuCodeMapper.to認定調査結果(entity);
    }
}
