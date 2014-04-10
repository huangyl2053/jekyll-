/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteiKekkaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定結果を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiResultManager {

    private final NinteiKekkaJohoDac dac;

    /**
     * InstanceCreatorを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public NinteiResultManager() {
        dac = InstanceProvider.create(NinteiKekkaJohoDac.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac 要介護認定結果情報Dac
     */
    NinteiResultManager(NinteiKekkaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 引数の条件に該当する認定結果を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定結果
     */
    public NinteiResult get認定結果(ShinseishoKanriNo 申請書管理番号) {
        return NinteiKekkaMapper.toNinteiResult(dac.select(申請書管理番号));
    }

    /**
     * 引数の認定結果を追加、または更新します。
     *
     * @param 認定結果 認定結果
     * @return 追加、または更新が成功した場合はtrueを返します。
     */
    public boolean save認定結果(NinteiResult 認定結果) {
        return dac.insert(NinteiKekkaMapper.toDbT5002NinteiKekkaJohoEntity(認定結果)) != 0;
    }

    /**
     * 引数の認定結果を削除します。
     *
     * @param 認定結果 認定結果
     * @return 削除が成功した場合はtrueを返します。
     */
    public boolean remove認定結果(NinteiResult 認定結果) {
        return dac.delete(NinteiKekkaMapper.toDbT5002NinteiKekkaJohoEntity(認定結果)) != 0;
    }
}
