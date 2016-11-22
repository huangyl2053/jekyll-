/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表（明細リスト）作成のEntityクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyuhuJissekiMeisaiEntity {

    private DbT3018KyufujissekiMeisaiEntity entity;
    private FlexibleYearMonth teikyoKaishiYM;
    private FlexibleYearMonth teikyoShuryoYM;
    private RString gendogakuTaishogaiFlag;
    private RString serviceShuruiFlag;
}
