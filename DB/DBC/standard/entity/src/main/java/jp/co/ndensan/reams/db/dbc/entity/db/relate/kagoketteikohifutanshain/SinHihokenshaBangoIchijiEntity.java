/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新被保険者番号一時テーブルに対するテーブルのエンティティ
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SinHihokenshaBangoIchijiEntity implements Serializable {

    private LasdecCode 市町村コード;
    private RString 新番号;
    private RString 旧番号;
}
