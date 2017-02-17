/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshotoroku;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshotoroku.ShujiiIkenshoTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshotoroku.ShujiiIkenshoTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 */
public class IShujiiIkenshoTorokuMapperTest extends DbeTestDacBase {

    @BeforeClass
    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

    @Test
    public void get関連データ() {
        IShujiiIkenshoTorokuMapper sut = this.sqlSession.getMapper(IShujiiIkenshoTorokuMapper.class);
        ShujiiIkenshoTorokuMapperParameter param = ShujiiIkenshoTorokuMapperParameter.findBy(new ShinseishoKanriNo("20211920150500061"));
        ShujiiIkenshoTorokuRelateEntity e = sut.getShujiiIkenshoForLoad(param);
        System.out.println(e.getShichosonCode());
        System.out.println("厚労省IF識別コード：" + e.getDbt5302Entity().getKoroshoIfShikibetsuCode());
    }
}
