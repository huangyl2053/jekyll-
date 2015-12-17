/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.shoKofuKaishuJoho;

import jp.co.ndensan.reams.db.dba.persistence.mapper.shoKofuKaishuJoho.ShoKofuKaishuJohoMapper;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.ShoKofuKaishuJohoModel;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.shokofukaishujoho.ShoKofuKaishuJohoParameter;
import jp.co.ndensan.reams.db.dba.entity.ShoKofuKaishuJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 証交付回収情報の取得処理です。
 */
public class ShoKofuKaishuJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT7037ShoKofuKaishuDac dac;

     /**
     * コンストラクタ
     */
    ShoKofuKaishuJohoManager(){
    this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    this.dac = InstanceProvider.create(DbT7037ShoKofuKaishuDac.class);
    }
    
     /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param dac dac
     */
    ShoKofuKaishuJohoManager(
            MapperProvider mapperProvider,
            DbT7037ShoKofuKaishuDac dac
    ) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

     /**
     * {@link InstanceProvider#create}にて生成した{@link ShoKofuKaishuJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShoKofuKaishuJohoManager}のインスタンス
     */
    public static ShoKofuKaishuJohoManager createInstance() {
        return InstanceProvider.create(ShoKofuKaishuJohoManager.class);
    }

    /**
     * 証交付回収情報データを返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 論理削除フラグ boolean
     * @return SearchResult<ShoKofuKaishuJohoModel>
     */
    public SearchResult<ShoKofuKaishuJohoModel> getShoKofuKaishuJohoList(HihokenshaNo 被保険者番号, boolean 論理削除フラグ) {
        List<ShoKofuKaishuJohoModel> businessList = new ArrayList<>();
        List<DbT7037ShoKofuKaishuEntity> dbT7037ShoKofuKaishuEntity = dac.select一覧取得(被保険者番号, 論理削除フラグ);
        for (DbT7037ShoKofuKaishuEntity fufukuMoshitateEntity : dbT7037ShoKofuKaishuEntity) {
            businessList.add(new ShoKofuKaishuJohoModel(fufukuMoshitateEntity));
        }

        return SearchResult.of(businessList, 0, false);
    }
    
     /**
     * 証交付回収の更新処理します。
     *
     * @param model
     * @return count
     */
    @Transaction
    public int updShoKofuKaishuJoho(ShoKofuKaishuJohoModel model) {
        ShoKofuKaishuJohoMapper mapper = mapperProvider.create(ShoKofuKaishuJohoMapper.class);
        ShoKofuKaishuJohoEntity entity = new ShoKofuKaishuJohoEntity();
        entity.setHihokenshaNo(model.get被保険者番号());
        entity.setHakkoShoriTimestamp(model.get処理日時());
        entity.setKaishuJiyu(model.get回収事由コード());
        entity.setKaishuRiyu(model.get回収理由());
        entity.setKaishuYMD(model.get回収年月日());
        entity.setKofuJiyu(model.get交付事由コード());
        entity.setKofuRiyu(model.get交付理由());
        entity.setKofuShoShurui(model.get交付証種類コード());
        entity.setKofuYMD(model.get交付年月日());
        entity.setYukoKigenYMD(model.get有効期限());
        int count = mapper.updShoKofuKaishuJoho(entity);
        return count;
    }

    /**
     * 証交付回収の保存処理結果を返します。
     *
     * @param shokoparameter
     * @return 証交付回収の保存処理結果
     */
    public int saveShoKofuKaishuJoho(ShoKofuKaishuJohoParameter shokoparameter) {
        if (shokoparameter.getState() == new RString("")) {
            return updShoKofuKaishuJoho(shokoparameter);
        } else {
            return delShoKofuKaishuJoho(shokoparameter);
        }

    }

    /**
     * キーに合致する更新件数を返します。
     *
     * @param div 証交付回収情報共有子DIVのDivController内のグリッドレコード
     * @return 更新件数
     */
    private int updShoKofuKaishuJoho(ShoKofuKaishuJohoParameter shokoparameter) {
        DbT7037ShoKofuKaishuEntity entity = dac.select更新処理(RString.EMPTY, HihokenshaNo.EMPTY, null);
        entity.setKofuYMD(new FlexibleDate("20151112"));// 引数．証交付回収情報共有子DIVのDivController．入力された交付日
        entity.setYukoKigenYMD(new FlexibleDate("20151112"));//引数．証交付回収情報共有子DIVのDivController．入力された有効期限
        entity.setKofuJiyu(new RString(""));//引数．証交付回収情報共有子DIVのDivController．選択された交付事由
        entity.setKofuRiyu(new RString(""));//引数．証交付回収情報共有子DIVのDivController．入力された交付理由
        entity.setKaishuYMD(new FlexibleDate("20151112"));//引数．証交付回収情報共有子DIVのDivController．入力された回収日
        entity.setKaishuJiyu(new RString(""));//引数．証交付回収情報共有子DIVのDivController．選択された回収事由
        entity.setKaishuRiyu(new RString(""));//引数．証交付回収情報共有子DIVのDivController．入力された回収理由
        return dac.save(entity);
    }

    /**
     * 証交付回収情報を削除します
     *
     * @param 交付証種類 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 処理日時 RDateTime
     *
     * @return 削除件数
     */
    @Transaction
    private int delShoKofuKaishuJoho(ShoKofuKaishuJohoParameter shokoparameter) {
        DbT7037ShoKofuKaishuEntity updateRecord = dac.select更新処理(RString.EMPTY, HihokenshaNo.EMPTY, RDateTime.MAX);
        updateRecord.setIsDeleted(true);
        return dac.save(updateRecord);
    }
}
