/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT38G1KetteishaIchiranTempEntity {

    private RString 申請対象年度;
    private RString no;
    private RString 金融機関コード;
    private RString 金融機関支店コード;
    private RString 口座種目;
    private HihokenshaNo 被保険者番号;

    /**
     * DbWT38G1KetteishaIchiranEntityにかわる。
     *
     * @return DbWT38G1KetteishaIchiranEntity
     */
    public DbWT38G1KetteishaIchiranEntity toEntity() {
        DbWT38G1KetteishaIchiranEntity entity = new DbWT38G1KetteishaIchiranEntity();
        entity.setShinseiTaishoNendo(申請対象年度);
        entity.setNo(no);
        entity.setKinyuKikanCode(金融機関コード);
        entity.setKinyuKikanShitenCode(金融機関支店コード);
        entity.setKozaShumoku(口座種目);
        entity.setHihokenshaNo(被保険者番号);
        return entity;
    }

}
