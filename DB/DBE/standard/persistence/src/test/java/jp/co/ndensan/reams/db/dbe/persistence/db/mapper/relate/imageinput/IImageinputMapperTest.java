/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imageinput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.IkenshoOcrContextParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.IkenshoContextEntity;
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
    public void get関連データ() {
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
        System.out.println(entity.getT5301_主治医意見書作成依頼年月日());
    }

    @Test
    public void getIkenshoContext() {
        IImageinputMapper sut = this.sqlSession.getMapper(IImageinputMapper.class);
        IkenshoOcrContextParameter param = new IkenshoOcrContextParameter(new RString("20602920160400289"), new RString("0000000029"), new RString("00000012"));
        IkenshoContextEntity entity = sut.getIkenshoContext(param);
        System.out.println(entity.get申請書管理番号());
        System.out.println(entity.getExists主治医区分());
    }
}
