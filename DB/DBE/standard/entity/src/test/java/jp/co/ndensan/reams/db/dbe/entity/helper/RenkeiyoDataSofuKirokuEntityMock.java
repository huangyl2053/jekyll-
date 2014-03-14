/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5022RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * RenkeiyoDataSofuKirokuEntityを生成するためのMockクラスです
 *
 * @author n8107
 */
public class RenkeiyoDataSofuKirokuEntityMock {

    public static DbT5022RenkeiyoDataSofuKirokuEntity getSpiedInstance() {

        DbT5022RenkeiyoDataSofuKirokuEntity entity = new DbT5022RenkeiyoDataSofuKirokuEntity();

        entity.setShinseishoKanriNo(new RString("100000001"));
        entity.setHihokenshaNo(new RString("H00000001"));
        entity.setNinteiShinseiShinseijiKubun(new RString("01"));
        entity.setHikiwatashiKubun(new RString("0"));
        entity.setHikiwatashiNichiji(RDateTime.of(2014, 03, 14, 18, 45, 59));
        entity.setSaiSoufuKubun(new RString("01"));
        entity.setSaiChousaSoufuKubun(new RString("0"));
        entity.setSaiIkenshoSoufuKubun(new RString("0"));

        return spy(entity);
    }
}
