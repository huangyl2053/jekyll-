/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imageinput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageinputRelateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * {@link IImageinputMapper}のテストです。
 */
public class IImageinputMapperTest extends DbeTestDacBase {

    public IImageinputMapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

    @Test
    public void testGet関連データ() {
        IImageinputMapper sut = this.sqlSession.getMapper(IImageinputMapper.class);
        ImageinputMapperParamter param = ImageinputMapperParamter.createParamter(new RString("202119"), new RString("0000008281"), new RString("20150601"));
        List<ImageinputRelateEntity> entities = sut.get関連データ(param);
        System.out.println(entities.isEmpty());
        ImageinputRelateEntity entity = entities.get(0);
        System.out.println(entity.get主治医意見書情報().isEmpty());
        System.out.println(entity.getT5101_被保険者カナ());
        System.out.println(entity.isT5101_論理削除フラグ());
        System.out.println(entity.isMatches指定申請日());
        System.out.println(entity.getT5105_一次判定完了日());
    }
}
