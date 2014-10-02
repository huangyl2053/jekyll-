/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.MobileDataShutsuryoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiCollection;

/**
 * 認定調査依頼情報のMapperクラスです。
 *
 * @author n8178 城間篤人
 */
public final class NinteichosaIraiMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private NinteichosaIraiMapper() {
    }

    /**
     * 認定調査依頼情報Entityを、認定調査依頼情報クラスにマッピングします。<br/>
     * 引数にnullが渡されたときはnullを返します。
     *
     * @param entity 認定調査依頼情報Entity
     * @return 認定調査依頼情報
     */
    public static NinteichosaIrai to認定調査依頼情報(DbT5006NinteichosaIraiJohoEntity entity) {
        if (entity == null) {
            return null;
        }

        return new NinteichosaIrai(entity.getShinseishoKanriNo(), entity.getNinteichosaIraiRirekiNo(),
                entity.getNinteichosaItakusakiCode(), entity.getChousainCode(),
                NinteichosaIraiKubun.toValue(entity.getNinteichousaIraiKubunCode()), entity.getNinteichosaIraiKaisu(),
                entity.getNinteichosaIraiYMD().toRDate(), entity.getNinteichosaKigenYMD().toRDate(),
                entity.getIraishoShutsuryokuYMD().toRDate(), entity.getChosahyoTouShutsuryokuYMD().toRDate(),
                MobileDataShutsuryoku.toValue(entity.getMobileDataShutsuryokuFlag()), entity.getNinteichosaTokusokuYMD().toRDate(),
                NinteichosaTokusokuHoho.toValue(entity.getNinteichosaTokusokuHoho()),
                entity.getNinteichosaTokusokuKaisu(), entity.getNinteichosaTokusokuMemo());
    }

    /**
     * 認定調査依頼情報のリストを受け取り、認定調査依頼情報コレクションに変換して返します。<br />
     * 引数にnullや空のリストが渡されたときは、空のコレクションを返します。
     *
     * @param entities 認定調査依頼情報Entityのリスト
     * @return 認定調査依頼情報コレクション
     */
    public static NinteichosaIraiCollection to認定調査依頼情報Collection(List<DbT5006NinteichosaIraiJohoEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new NinteichosaIraiCollection(Collections.EMPTY_LIST);
        }

        List<NinteichosaIrai> iraiJohoList = new ArrayList<>();
        for (DbT5006NinteichosaIraiJohoEntity entity : entities) {
            iraiJohoList.add(to認定調査依頼情報(entity));
        }
        return new NinteichosaIraiCollection(iraiJohoList);
    }

    /**
     * 認定調査依頼情報Entityを、認定調査依頼情報クラスにマッピングします。
     *
     * @param iraiJoho 認定調査依頼情報
     * @return 認定調査依頼情報Entity
     */
    public static DbT5006NinteichosaIraiJohoEntity to認定調査依頼情報Entity(NinteichosaIrai iraiJoho) {
        if (iraiJoho == null) {
            return null;
        }

        DbT5006NinteichosaIraiJohoEntity entity = new DbT5006NinteichosaIraiJohoEntity();
        entity.setShinseishoKanriNo(iraiJoho.get申請書管理番号());
        entity.setNinteichosaIraiRirekiNo(iraiJoho.get認定調査依頼履歴番号());
        entity.setNinteichosaItakusakiCode(iraiJoho.get認定調査委託先コード());
        entity.setChousainCode(iraiJoho.get調査員番号コード());
        entity.setNinteichousaIraiKubunCode(iraiJoho.get認定調査依頼区分().getCode());
        entity.setNinteichosaIraiKaisu(iraiJoho.get認定調査回数());
        entity.setNinteichosaIraiYMD(iraiJoho.get認定調査依頼年月日().toFlexibleDate());
        entity.setNinteichosaKigenYMD(iraiJoho.get認定調査期限年月日().toFlexibleDate());
        entity.setIraishoShutsuryokuYMD(iraiJoho.get認定調査出力年月日().toFlexibleDate());
        entity.setChosahyoTouShutsuryokuYMD(iraiJoho.get調査票等出力年月日().toFlexibleDate());
        entity.setMobileDataShutsuryokuFlag(iraiJoho.getモバイルデータ出力().is出力済());
        entity.setNinteichosaTokusokuYMD(iraiJoho.get認定調査督促年月日().toFlexibleDate());
        entity.setNinteichosaTokusokuHoho(iraiJoho.get認定調査督促方法().getCode());
        entity.setNinteichosaTokusokuKaisu(iraiJoho.get認定調査督促回数());
        entity.setNinteichosaTokusokuMemo(iraiJoho.get認定調査督促メモ());
        return entity;
    }
}
