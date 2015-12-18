/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.shokaishukanri;


import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author x_wangxs2
 */
@Getter
@Setter
public class SyokofukaisyuzyohouEntity {

    private RString 交付証種類コード;
    private RString 処理日時;
    private FlexibleDate 交付日;
    private FlexibleDate 有効期限;
    private RString 交付事由;
    private RString 交付理由;
    private FlexibleDate 回収日;
    private RString 回収事由;
    private RString 更新_削除区分;
    
    
}
