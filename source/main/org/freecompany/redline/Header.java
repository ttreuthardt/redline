package org.freecompany.redline;

import java.util.*;
import java.util.concurrent.*;

import static org.freecompany.redline.Type.*;

public class Header extends AbstractHeader< Header.Tag> {

	public enum Tag {

		RPM_NAME( 1000, STRING),
		RPM_VERSION( 1001, STRING),
		RPM_RELEASE( 1002, STRING),
		RPM_SUMMARY( 1004, STRING),
		RPM_DESCRIPTION( 1005, STRING),
		RPM_BUILDTIME( 1006, STRING),
		RPM_BUILDHOST( 1007, STRING),
		RPM_SIZE( 1009, STRING),
		RPM_VENDOR( 1011, STRING);

		private static Map< Integer, Tag> tags = new ConcurrentHashMap< Integer, Tag>();
		private int code;
		private Type type;

		private Tag( int code, Type type) {
			this.code = code;
			this.type = type;
		}

		public int getCode() {
			return code;
		}

		public Type getType() {
			return type;
		}

		public static Tag getTag( int code) {
			return tags.get( code);
		}
	}

	protected Tag getTag( int code) {
		return Tag.getTag( code);
	}
}