/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosakekkatorikomiocr;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.ChosahyoOcrContextParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaContextEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaKekkaTorikomiOcrRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosahyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link INinteiOcrMapper}のテストです。
 */
@RunWith(Enclosed.class)
public class INinteiOcrMapperTest extends DbeTestDacBase {

    public INinteiOcrMapperTest() {
    }

    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

    public static class Get関連データ {

        @Test
        public void get関連データ() {
            System.out.println("- get関連データ() -------------------------------");
//            NinteiOcrMapperParamter param = NinteiOcrMapperParamter.createParamter(new RString("205625"), new RString("0000041157"), new RString("19990913"));
//            NinteiOcrMapperParamter param = NinteiOcrMapperParamter.createParamter(new RString("206029"), new RString("0000008371"), new RString("20170301"));
            NinteiOcrMapperParamter param = NinteiOcrMapperParamter.searchByAmbiguousParams(new RString("209732"), new RString("0000000234"), new RString("20170323"));
            INinteiOcrMapper sut = sqlSession.getMapper(INinteiOcrMapper.class);

            List<NinteiChosaKekkaTorikomiOcrRelateEntity> list = sut.get関連データ(param);
            NinteiChosaKekkaTorikomiOcrRelateEntity entity = list.get(0);
            System.out.println(entity.get被保険者氏名());
            System.out.println(entity.is論理削除フラグ());
            System.out.println(entity.isMatches指定申請日());
            System.out.println(entity.get認定調査依頼完了日());
            System.out.println(entity.get仮一次判定区分());
            System.out.println(entity.get申請書管理番号());
            System.out.println("審査会完了日　：" + entity.get認定審査会完了日());
            System.out.println("取下区分コード：" + entity.get取下区分コード());
        }

        @Test
        public void find調査員() {
            System.out.println("- find調査員() ---------------------------------");
            ChosahyoOcrContextParameter param = new ChosahyoOcrContextParameter(new RString("00000020161200002"), new RString("0000000035"), new RString("00000001"));
            INinteiOcrMapper sut = sqlSession.getMapper(INinteiOcrMapper.class);
            NinteiChosaContextEntity entity = sut.getNinteiChosaContext(param);
            if (entity != null) {
                System.out.println("調査員　　存在:");
                System.out.println(entity.getExists調査員区分());
            }

            ChosahyoOcrContextParameter param2 = new ChosahyoOcrContextParameter(new RString("00000020161200002"), new RString("0000000035"), new RString("01000033"));
            entity = sut.getNinteiChosaContext(param2);
            if (entity != null) {
                System.out.println("調査員　不存在:");
                System.out.println(entity.getExists調査員区分());
            }

            ChosahyoOcrContextParameter param3 = new ChosahyoOcrContextParameter(new RString("00000020161200002"), new RString("0990000003"), new RString("00000033"));
            entity = sut.getNinteiChosaContext(param3);
            if (entity != null) {
                System.out.println("委託先　不存在:");
                System.out.println(entity.getExists調査員区分());
            }
        }

        @Test
        public void get認定調査票() {
            System.out.println("- get認定調査票() -------------------------------");
            NinteiOcrMapperParamter param = NinteiOcrMapperParamter.searchByShinseishoKanriNo(new ShinseishoKanriNo("20973220170300323"));
            INinteiOcrMapper sut = sqlSession.getMapper(INinteiOcrMapper.class);
            List<NinteiChosahyoEntity> list = sut.get認定調査票(param);
            NinteiChosahyoEntity entity = list.get(0);

            System.out.println(entity.get基本調査().size());
            System.out.println(entity.getサービスの状況().size());
            System.out.println(entity.getサービスの状況フラグ().size());
            System.out.println(entity.get記入項目().size());
            System.out.println(entity.get基本調査().isEmpty());
        }
    }
}
