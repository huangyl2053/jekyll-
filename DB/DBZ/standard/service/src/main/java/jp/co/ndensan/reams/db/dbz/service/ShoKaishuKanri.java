/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.entity.shokaishukanri.SyokofukaisyuzyohouEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 証交付回収の更新処理クラスです。
 * 
 * @author x_wangxs2
 */
public class ShoKaishuKanri {
    private static final RString 修正 = new RString("1");
    private static final RString 削除 = new RString("0");
    DbT7037ShoKofuKaishuDac dac = new DbT7037ShoKofuKaishuDac();
    
    public ShoKaishuKanri() {
    }
    
    /**
     * 被保険者番号、交付証種類によって、証交付回収情報を更新します。
     * @param 被保険者番号
     * @param　syokofukaisyuzyohouEntitys　　証交付回収情報共有子DIVのDivControllerのList
     * @throws Exception 
     */
    @SuppressWarnings("empty-statement")
    public void updShoKofuKaishu(HihokenshaNo 被保険者番号, List<SyokofukaisyuzyohouEntity> syokofukaisyuzyohouEntitys) throws Exception {
        for (SyokofukaisyuzyohouEntity syokofukaisyuzyohouEntity : syokofukaisyuzyohouEntitys) {
                DbT7037ShoKofuKaishuDac dac = InstanceProvider.create(DbT7037ShoKofuKaishuDac.class);
                DbT7037ShoKofuKaishuEntity dbT7037ShoKofuKaishuEntity = new DbT7037ShoKofuKaishuEntity();
            if (修正.equals(syokofukaisyuzyohouEntity.get更新_削除区分())) {
                dbT7037ShoKofuKaishuEntity.setKofuYMD(syokofukaisyuzyohouEntity.get交付日());
                dbT7037ShoKofuKaishuEntity.setYukoKigenYMD(syokofukaisyuzyohouEntity.get有効期限());
                dbT7037ShoKofuKaishuEntity.setKofuJiyu(syokofukaisyuzyohouEntity.get交付事由());
                dbT7037ShoKofuKaishuEntity.setKofuRiyu(syokofukaisyuzyohouEntity.get交付理由());
                dbT7037ShoKofuKaishuEntity.setKaishuYMD(syokofukaisyuzyohouEntity.get回収日());
                dbT7037ShoKofuKaishuEntity.setKaishuJiyu(syokofukaisyuzyohouEntity.get回収事由());
                // TODO dbT7037ShoKofuKaishuEntity.setKaishuRiyu(syokofukaisyuzyohouEntity.get);
                dbT7037ShoKofuKaishuEntity.setHakkoShoriTimestamp(new YMDHMS(RDate.getNowDateTime()));
                dbT7037ShoKofuKaishuEntity.setHihokenshaNo(被保険者番号);
                dbT7037ShoKofuKaishuEntity.setKofuShoShurui(syokofukaisyuzyohouEntity.get交付証種類コード());
                dac.updateShoKaishuKanri(dbT7037ShoKofuKaishuEntity);
            }else if
                (削除.equals(syokofukaisyuzyohouEntity.get更新_削除区分())) {
                dbT7037ShoKofuKaishuEntity.setIsDeleted(true);
                dbT7037ShoKofuKaishuEntity.setHakkoShoriTimestamp(new YMDHMS(RDate.getNowDateTime()));
                dac.update(dbT7037ShoKofuKaishuEntity);
            }           
        }
    }
}

 