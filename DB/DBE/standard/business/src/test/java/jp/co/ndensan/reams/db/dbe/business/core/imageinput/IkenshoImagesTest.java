/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.imageinput;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IkenshoImages}のテストです。
 */
@RunWith(Enclosed.class)
public class IkenshoImagesTest {

    private static final ShinseishoKanriNo SHINSEISHO_KANRI_NO = new ShinseishoKanriNo("000000000000001");

    public IkenshoImagesTest() {
    }

    public static class empty {

        private IkenshoImages sut;

        @Before
        public void setUp() {
            sut = new IkenshoImages(SHINSEISHO_KANRI_NO, 0, Collections.<DbT5305IkenshoImageJohoEntity>emptyList());
        }

        @Test
        public void 何もない状態で_777を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777).gemponAsMap();
            assertThat(result.size(), is(1));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
        }

        @Test
        public void 何もない状態で_777と778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777, OCRID._778).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._778.value()).isAdded(), is(true));
        }

        @Test(expected = SystemException.class)
        public void 何もない状態で_701と777を追加する() {
            sut.added(OCRID._701, OCRID._777);
        }
    }

    private static DbT5305IkenshoImageJohoEntity newEntity(OCRID ocrID) {
        DbT5305IkenshoImageJohoEntity e = new IkenshoImageJoho(SHINSEISHO_KANRI_NO, 0, ocrID.asCode(), GenponMaskKubun.原本.getコード(), 1).toEntity();
        e.initializeMd5();
        return e;
    }

    public static class alreadyHas777 {

        private IkenshoImages sut;

        @Before
        public void setUp() {
            DbT5305IkenshoImageJohoEntity e = newEntity(OCRID._777);
            sut = new IkenshoImages(SHINSEISHO_KANRI_NO, 0, Arrays.asList(e));
        }

        @Test
        public void _777のみを保持する状態で_777を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777).gemponAsMap();
            assertThat(result.size(), is(1));
            assertThat(result.get(OCRID._777.value()).isUnchanged(), is(true));
        }

        @Test
        public void _777のみを保持する状態で_778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._778).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._777.value()).isUnchanged(), is(true));
            assertThat(result.get(OCRID._778.value()).isAdded(), is(true));
        }

        @Test
        public void _777のみを保持する状態で_777と778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777, OCRID._778).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._777.value()).isUnchanged(), is(true));
            assertThat(result.get(OCRID._778.value()).isAdded(), is(true));
        }

        @Test
        public void _777のみを保持する状態で_701を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._777.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._701.value()).isAdded(), is(true));
        }

        @Test
        public void _777のみを保持する状態で_702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._702).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._777.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._702.value()).isAdded(), is(true));
        }

        @Test
        public void _777のみを保持する状態で_701と702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701, OCRID._702).gemponAsMap();
            assertThat(result.size(), is(3));
            assertThat(result.get(OCRID._777.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._701.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._702.value()).isAdded(), is(true));
        }
    }

    public static class alreadyHas778 {

        private IkenshoImages sut;

        @Before
        public void setUp() {
            DbT5305IkenshoImageJohoEntity e = newEntity(OCRID._778);
            sut = new IkenshoImages(SHINSEISHO_KANRI_NO, 0, Arrays.asList(e));
        }

        @Test
        public void _778のみを保持する状態で_777を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._778.value()).isUnchanged(), is(true));
        }

        @Test
        public void _778のみを保持する状態で_778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._778).gemponAsMap();
            assertThat(result.size(), is(1));
            assertThat(result.get(OCRID._778.value()).isUnchanged(), is(true));
        }

        @Test
        public void _778のみを保持する状態で_777と778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777, OCRID._778).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._778.value()).isUnchanged(), is(true));
        }

        @Test
        public void _778のみを保持する状態で_701を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._778.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._701.value()).isAdded(), is(true));
        }

        @Test
        public void _778のみを保持する状態で_702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._702).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._778.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._702.value()).isAdded(), is(true));
        }

        @Test
        public void _778のみを保持する状態で_701と702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701, OCRID._702).gemponAsMap();
            assertThat(result.size(), is(3));
            assertThat(result.get(OCRID._778.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._701.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._702.value()).isAdded(), is(true));
        }
    }

    public static class alreadyHas777and778 {

        private IkenshoImages sut;

        @Before
        public void setUp() {
            DbT5305IkenshoImageJohoEntity e = newEntity(OCRID._778);
            DbT5305IkenshoImageJohoEntity e2 = newEntity(OCRID._777);
            sut = new IkenshoImages(SHINSEISHO_KANRI_NO, 0, Arrays.asList(e, e2));
        }

        @Test
        public void _777と778を保持する状態で_777を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._777.value()).isUnchanged(), is(true));
            assertThat(result.get(OCRID._778.value()).isUnchanged(), is(true));
        }

        @Test
        public void _777と778を保持する状態で_778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._778).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._777.value()).isUnchanged(), is(true));
            assertThat(result.get(OCRID._778.value()).isUnchanged(), is(true));
        }

        @Test
        public void _777と778を保持する状態で_777と778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777, OCRID._778).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._777.value()).isUnchanged(), is(true));
            assertThat(result.get(OCRID._778.value()).isUnchanged(), is(true));
        }

        @Test
        public void _777と778を保持する状態で_701を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701).gemponAsMap();
            assertThat(result.size(), is(3));
            assertThat(result.get(OCRID._777.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._778.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._701.value()).isAdded(), is(true));
        }

        @Test
        public void _777と778を保持する状態で_702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._702).gemponAsMap();
            assertThat(result.size(), is(3));
            assertThat(result.get(OCRID._777.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._778.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._702.value()).isAdded(), is(true));
        }

        @Test
        public void _777と778を保持する状態で_701と702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701, OCRID._702).gemponAsMap();
            assertThat(result.size(), is(4));
            assertThat(result.get(OCRID._777.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._778.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._701.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._702.value()).isAdded(), is(true));
        }
    }

    public static class alreadyHas701 {

        private IkenshoImages sut;

        @Before
        public void setUp() {
            DbT5305IkenshoImageJohoEntity e = newEntity(OCRID._701);
            sut = new IkenshoImages(SHINSEISHO_KANRI_NO, 0, Arrays.asList(e));
        }

        @Test
        public void _701のみを保持する状態で_701を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701).gemponAsMap();
            assertThat(result.size(), is(1));
            assertThat(result.get(OCRID._701.value()).isUnchanged(), is(true));
        }

        @Test
        public void _701のみを保持する状態で_702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._702).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._701.value()).isUnchanged(), is(true));
            assertThat(result.get(OCRID._702.value()).isAdded(), is(true));
        }

        @Test
        public void _701のみを保持する状態で_701と702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701, OCRID._702).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._701.value()).isUnchanged(), is(true));
            assertThat(result.get(OCRID._702.value()).isAdded(), is(true));
        }

        @Test
        public void _701のみを保持する状態で_777を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._701.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
        }

        @Test
        public void _701のみを保持する状態で_778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._778).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._701.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._778.value()).isAdded(), is(true));
        }

        @Test
        public void _701のみを保持する状態で_777と778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777, OCRID._778).gemponAsMap();
            assertThat(result.size(), is(3));
            assertThat(result.get(OCRID._701.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._778.value()).isAdded(), is(true));
        }
    }

    public static class alreadyHas702 {

        private IkenshoImages sut;

        @Before
        public void setUp() {
            DbT5305IkenshoImageJohoEntity e = newEntity(OCRID._702);
            sut = new IkenshoImages(SHINSEISHO_KANRI_NO, 0, Arrays.asList(e));
        }

        @Test
        public void _702のみを保持する状態で_701を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._701.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._702.value()).isUnchanged(), is(true));
        }

        @Test
        public void _702のみを保持する状態で_702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._702).gemponAsMap();
            assertThat(result.size(), is(1));
            assertThat(result.get(OCRID._702.value()).isUnchanged(), is(true));
        }

        @Test
        public void _702のみを保持する状態で_701と702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701, OCRID._702).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._701.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._702.value()).isUnchanged(), is(true));
        }

        @Test
        public void _702のみを保持する状態で_777を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._702.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
        }

        @Test
        public void _702のみを保持する状態で_778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._778).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._702.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._778.value()).isAdded(), is(true));
        }

        @Test
        public void _702のみを保持する状態で_777と778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777, OCRID._778).gemponAsMap();
            assertThat(result.size(), is(3));
            assertThat(result.get(OCRID._702.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._778.value()).isAdded(), is(true));
        }
    }

    public static class alreadyHas701and702 {

        private IkenshoImages sut;

        @Before
        public void setUp() {
            DbT5305IkenshoImageJohoEntity e = newEntity(OCRID._702);
            DbT5305IkenshoImageJohoEntity e2 = newEntity(OCRID._701);
            sut = new IkenshoImages(SHINSEISHO_KANRI_NO, 0, Arrays.asList(e2, e));
        }

        @Test
        public void _701と702を保持する状態で_701を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._701.value()).isUnchanged(), is(true));
            assertThat(result.get(OCRID._702.value()).isUnchanged(), is(true));
        }

        @Test
        public void _701と702を保持する状態で_702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._702).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._701.value()).isUnchanged(), is(true));
            assertThat(result.get(OCRID._702.value()).isUnchanged(), is(true));
        }

        @Test
        public void _701と702を保持する状態で_701と702を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._701, OCRID._702).gemponAsMap();
            assertThat(result.size(), is(2));
            assertThat(result.get(OCRID._701.value()).isUnchanged(), is(true));
            assertThat(result.get(OCRID._702.value()).isUnchanged(), is(true));
        }

        @Test
        public void _701と702を保持する状態で_777を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777).gemponAsMap();
            assertThat(result.size(), is(3));
            assertThat(result.get(OCRID._701.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._702.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
        }

        @Test
        public void _701と702を保持する状態で_778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._778).gemponAsMap();
            assertThat(result.size(), is(3));
            assertThat(result.get(OCRID._701.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._702.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._778.value()).isAdded(), is(true));
        }

        @Test
        public void _701と702を保持する状態で_777と778を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777, OCRID._778).gemponAsMap();
            assertThat(result.size(), is(4));
            assertThat(result.get(OCRID._701.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._702.value()).isDeleted(), is(true));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
            assertThat(result.get(OCRID._778.value()).isAdded(), is(true));
        }
    }

    private static DbT5305IkenshoImageJohoEntity newEntityMasked(OCRID ocrID) {
        DbT5305IkenshoImageJohoEntity e = new IkenshoImageJoho(SHINSEISHO_KANRI_NO, 0, ocrID.asCode(), GenponMaskKubun.マスク.getコード(), 1).toEntity();
        e.initializeMd5();
        return e;
    }

    public static class hasMasked {

        private IkenshoImages sut;

        @Before
        public void setUp() {
            DbT5305IkenshoImageJohoEntity e = newEntityMasked(OCRID._701);
            sut = new IkenshoImages(SHINSEISHO_KANRI_NO, 0, Arrays.asList(e));
        }

        @Test
        public void _701のみを保持する状態で_777を追加する() {
            Map<RString, IkenshoImageJoho> result = sut.added(OCRID._777).gemponAsMap();
            assertThat(result.size(), is(1));
            assertThat(result.get(OCRID._777.value()).isAdded(), is(true));
            Map<RString, IkenshoImageJoho> resultMasked = sut.added(OCRID._777).maskedAsMap();
            assertThat(resultMasked.size(), is(1));
            assertThat(resultMasked.get(OCRID._701.value()).isDeleted(), is(true));
        }
    }
}
