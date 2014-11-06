/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuHairetsuCode;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuList;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultDetail;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.IchijiHanteiKeikokuMapper;
import jp.co.ndensan.reams.db.dbe.business.mapper.IchijiHanteiResultDetailMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IchijiHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 一次判定の情報を管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiResultManager {

    private final IchijiHanteiKekkaDac dac;

    /**
     * デフォルトコンストラクタです。
     */
    public IchijiHanteiResultManager() {
        dac = InstanceProvider.create(IchijiHanteiKekkaDac.class);
    }

    /**
     * 外部からDacを受け取る、テスト用コンストラクタです。
     *
     * @param dac テスト用Dac
     */
    IchijiHanteiResultManager(IchijiHanteiKekkaDac dac) {
        this.dac = dac;
    }

    /**
     * 申請書管理番号を指定し、該当する一次判定結果の情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 一次判定結果
     */
    public IchijiHanteiResultDetail get一次判定結果(ShinseishoKanriNo 申請書管理番号) {
        DbT5016IchijiHanteiKekkaJohoEntity entity = dac.select(申請書管理番号);

        IchijiHanteiKeikokuList list = IchijiHanteiKeikokuMapper.to一次判定警告List(create警告配列コード(entity));
        return IchijiHanteiResultDetailMapper.to一次判定結果(entity, list);
    }

    private IchijiHanteiKeikokuHairetsuCode create警告配列コード(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        RString 警告配列コード文字列 = entity.getIchijiHanteiKeikokuCode();
        FlexibleDate 判定年月日 = entity.getIchijiHanteiYMD();
        return new IchijiHanteiKeikokuHairetsuCode(警告配列コード文字列, 判定年月日);
    }

    /**
     * DLLで計算された一次判定計算結果を元に、一次判定結果を返します。
     *
     * @param dll一次判定計算結果 dll一次判定計算結果
     * @return 一次判定結果
     */
    public IchijiHanteiResultDetail get一次判定結果(IchijiHanteiResultDetail dll一次判定計算結果) {
        //TODO n8178 城間篤人 DLLから情報がどのように渡るかの詳細が決まった後に、改めて実装を行う 2014年3月
        return dll一次判定計算結果;
    }

    /**
     * 引数から受け取った一次判定結果の情報を保存します。
     *
     * @param 一次判定結果 一次判定結果
     * @return 保存に成功したらtrue
     */
    public boolean save(IchijiHanteiResultDetail 一次判定結果) {
        DbT5016IchijiHanteiKekkaJohoEntity entity = IchijiHanteiResultDetailMapper.to一次判定結果Entity(一次判定結果);
        return dac.insertOrUpdate(entity) == 1 ? true : false;
    }

    /**
     * 引数から受け取った一次判定結果の情報を削除します。
     *
     * @param 一次判定結果 一次判定結果
     * @return 削除に成功したらtrue
     */
    public boolean remove(IchijiHanteiResultDetail 一次判定結果) {
        DbT5016IchijiHanteiKekkaJohoEntity entity = IchijiHanteiResultDetailMapper.to一次判定結果Entity(一次判定結果);
        return dac.delete(entity) == 1 ? true : false;
    }
}
