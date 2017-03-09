/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imageinput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageInputSontaRelateEntity;
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
    public void get意見書関連データ() {
        System.out.println("- get意見書関連データ() -----------------------------");
        IImageinputMapper sut = this.sqlSession.getMapper(IImageinputMapper.class);
//        ImageinputMapperParamter param = ImageinputMapperParamter.createParamter(new RString("202119"), new RString("0000008281"), new RString("20150601"));
//        ImageinputMapperParamter param = ImageinputMapperParamter.createParamter(new RString("202119"), new RString("0000287539"), new RString("19990917"));
        ImageinputMapperParamter param = ImageinputMapperParamter.createParamter(new RString("202119"), new RString("0000124231"), new RString("20991020"));
        List<ImageinputRelateEntity> entities = sut.get意見書関連データ(param);
        System.out.println(entities.isEmpty());
        ImageinputRelateEntity entity = entities.get(0);
        System.out.println("\t被保カナ：" + entity.get被保険者カナ());
        System.out.println("\t論削フラ：" + entity.is論理削除フラグ());
        System.out.println("\tmc申請日：" + entity.isMatches指定申請日());
        System.out.println("\t意作依日：" + entity.get主治医意見書作成依頼年月日());
        System.out.println("\t意依完日：" + entity.get意見書作成依頼完了日());
        System.out.println("\t仮一次区：" + entity.get仮一次判定区分());
        System.out.println("\tイメージ：" + entity.get意見書イメージ情報().isEmpty());
        System.out.println("\t審会完日：" + entity.get認定審査会完了日());
    }

    @Test
    public void getその他資料関連データ() {
        System.out.println("- getその他資料関連データ() -------------------------");
        IImageinputMapper sut = this.sqlSession.getMapper(IImageinputMapper.class);
        ImageinputMapperParamter param = ImageinputMapperParamter.createParamter(new RString("202119"), new RString("0000124231"), new RString("20991020"));
        List<ImageInputSontaRelateEntity> entities = sut.getその他資料関連データ(param);
        ImageInputSontaRelateEntity entity = entities.get(0);
        System.out.println("\t被保カナ：" + entity.getHihokenshaKana());
        System.out.println("\t論削フラ：" + entity.isLogicalDeletedFlag());
        System.out.println("\t認申請日：" + entity.isMatchesShiteiShinseiYMD());
        System.out.println("\t意依完日：" + entity.getIkenshoSakuseiIraiKanryoYMD());
        System.out.println("\t調依完日：" + entity.getNinteichosaIraiKanryoYMD());
        System.out.println("\t仮一次区：" + entity.getKariIchijiHanteiKubun());
        System.out.println("\t審会完日：" + entity.getNinteiShinsakaiKanryoYMD());
    }
}
