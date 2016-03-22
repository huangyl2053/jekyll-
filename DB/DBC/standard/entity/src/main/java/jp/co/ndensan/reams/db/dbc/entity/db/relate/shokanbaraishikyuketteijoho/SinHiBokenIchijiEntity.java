/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 新番号の取得対するテーブルのエンティティ
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SinHiBokenIchijiEntity implements Serializable {

    private LasdecCode 市町村コード;
    private RString 新番号;
    private RString 旧番号;
}
